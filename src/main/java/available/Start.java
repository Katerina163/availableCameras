package available;

public class Start {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }
        Parse parse = new ParseVC();
        Storage storage = parse.parse(args[0]);
        storage.showAll();
    }
}
