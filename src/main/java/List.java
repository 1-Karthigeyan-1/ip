public class List {

    public static void showList(Task[] storeText) {
        int itemCount = 1;
        String itemList = "";
        for (Task item : storeText) {
            itemList += Integer.toString(itemCount) + ". "  +  item.printDescription() + "\n";
            itemCount++;
        }
        Duke.textSeparator("Here are the tasks in your list:\n" + itemList);
    }
}
