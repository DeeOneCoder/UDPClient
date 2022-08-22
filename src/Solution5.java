
import java.util.*;

class Chat {

    List<String> members;
    List<Integer> files;
    HashMap<Integer, String> message;

    public Chat() {
        members = new ArrayList<>();
        files = new ArrayList<>();
        message = new HashMap<>();
    }

    public void add(String[] names) {
        int length = names.length;
        for (int i = 0; i < length; i++) {
            members.add(names[i]);
        }
    }

    public void add(int[] ids) {
        for (int i : ids) {
            files.add(i);
        }
    }

    public void add(int id, String newMessage) {
        message.put(id, newMessage);
    }

    public void remove(String[] names) {
        for (String name : names) {
            if (members.contains(name)) {
                members.remove(name);
            } else {
                System.out.println("Member with name " + name + " does not exist");
            }
        }
    }

    public void remove(int[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int check = ids[i];
            if (files.contains(check)) {
                int index = files.indexOf(check);
                files.remove(index);
            } else {
                System.out.println("File with id {" + i + "} does not exist");
            }
        }
    }

    public void remove(int id) {
        if (message.containsKey(id)) {
            message.remove(id, message.get(id));
        } else {
            System.out.println("Message with id {" + id + "} does not exixt");
        }
    }

    public void printConversation() {
        System.out.println("Total number of members in the conversation are " + members.size());
        System.out.print("The names of these members are {");
        for (String name : members) {
            System.out.print(name + " ");
        }
        System.out.print("}");
        System.out.println("Total number of files in the conversation are " + files.size());

        System.out.print("The messages in the conversation are {");

        for (int j : message.keySet()) {
            System.out.println("'" + message.get(j) + "'");
        }
        System.out.print("}");
    }
}

/* model ouput for cut and paste
Member with name ____ does not exist
File with id ____ does not exist
Message with id ____ does not exist
Total number of members in the conversation are ____
The names of these members are ____
Total number of files in the conversation are ____
The messages in the conversation are ____
*/
public class Solution5 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        String[] lineArray = sc.nextLine().split(" ");

        Chat newChat = new Chat();
        newChat.add(lineArray);

        lineArray = sc.nextLine().split(" ");

        int[] files = new int[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            files[i] = Integer.parseInt(lineArray[i]);
        }
        newChat.add(files);

        String line = sc.nextLine();
        int numberOfMessages = Integer.parseInt(line);

        for (int i = 0; i < numberOfMessages; i++) {
            line = sc.nextLine();
            newChat.add(i, line);
        }

        lineArray = sc.nextLine().split(" ");
        newChat.remove(lineArray);

        lineArray = sc.nextLine().split(" ");
        int[] filesRemoved = new int[lineArray.length];
        for (int i = 0; i < lineArray.length; i++) {
            filesRemoved[i] = Integer.parseInt(lineArray[i]);
        }
        newChat.remove(filesRemoved);

        lineArray = sc.nextLine().split(" ");
        for (int i = 0; i < lineArray.length; i++) {
            newChat.remove(Integer.parseInt(lineArray[i]));
        }

        newChat.printConversation();
    }
}