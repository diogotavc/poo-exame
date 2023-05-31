
public class ClientType {
    private String type;
    public static final String NORMAL = "normal";
    public static final String MEMBER = "sócio";

    public ClientType(String type) {
        this.type = type;
    }

    public static boolean isNormal(ClientType clientType) {
        return clientType.type.equals(NORMAL);
    }

    public static boolean isMember(ClientType clientType) {
        return clientType.type.equals(MEMBER);
    }
}