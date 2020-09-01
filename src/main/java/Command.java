public class Command {
    public static final String LIST = "list";
    public static final String BYE = "bye";
    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";
    public static final String DONE = "done";

    public static String parseArgument (String argument) {
        String[] argumentList = argument.split(" ",2);
        return argumentList[0];
    }

}
