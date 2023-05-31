

public class SpaceType {
    private String type;
    public static final String CaravanSpace = "caravanspace";
    public static final String CarSpace = "carspace";
    public static final String TentSpace = "tentspace";

    public SpaceType(String type) {
        this.type = type;
    }

    public static boolean isCaravanSpace(SpaceType clientType) {
        return clientType.type.equals(CaravanSpace);
    }

    public static boolean isCarSpace(SpaceType clientType) {
        return clientType.type.equals(CarSpace);
    }

    public static boolean isTentSpace(SpaceType clientType) {
        return clientType.type.equals(TentSpace);
    }
}
