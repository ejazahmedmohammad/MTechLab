import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.*;

class EchoServer {
private Selector selector;
private ServerSocketChannel serverSocket;
private boolean stop = false;
private List<String> pendingStrings;

public EchoServer() throws IOException {
    // Get selector
    this.selector = Selector.open();
    System.out.println("Selector open: " + selector.isOpen());
    // Get server socket channel and register with selector
    this.serverSocket = ServerSocketChannel.open();
    InetSocketAddress hostAddress = new InetSocketAddress("", NetworkingSettings.PORT);
    serverSocket.bind(hostAddress);
    serverSocket.configureBlocking(false);
    int ops = serverSocket.validOps();
    SelectionKey selectKy = serverSocket.register(selector, ops, null);
    this.pendingStrings = new ArrayList<>();
}

@Override
public void run() {
    while (!stop) {
        try {
            update();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

private void update() throws IOException {
    System.out.println("Waiting for select...");
    int noOfKeys = selector.select();

    System.out.println("Number of selected keys: " + noOfKeys);

    Set selectedKeys = selector.selectedKeys();
    Iterator iter = selectedKeys.iterator();

    while (iter.hasNext()) {

        SelectionKey ky = (SelectionKey) iter.next();
        if (ky.isAcceptable()) {
            acceptClient();
        }
        else if (ky.isReadable()) {
            readDataFromClient(ky);
        }
        iter.remove();
    }
}
}
