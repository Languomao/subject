package parse.telemetryparse.interfacexrbeans;

/**
 * Classname KeysObject
 * Date 2020/6/16 9:52
 * Created by LanKorment
 */
public class KeysObject {
    public String interface_name;

    public String getNode_name() {
        return interface_name;
    }

    public void setNode_name(String node_name) {
        this.interface_name = interface_name;
    }

    @Override
    public String toString() {
        return "Key[interface-name = " + interface_name + "]";
    }
}
