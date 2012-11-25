package backtype.storm.spout;

import java.io.Serializable;


/**
 * Kestrel Connection Info Entity Class
 */
public class HostInfo implements Serializable
{
    private static final long serialVersionUID = -5648480077543237139L;
    public String host;
    public int port;
    
    public HostInfo(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
