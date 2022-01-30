public class Rope {
    Node headNode;

    public Rope(String string) {
        headNode = new Node(0, null);
        Node ptr = headNode;
        String[] sentence = string.split(" ");
        // hazf " haye aval va akhar
        sentence[0] = sentence[0].substring(1);
        sentence[sentence.length - 1] = sentence[sentence.length - 1].substring(0, sentence[sentence.length - 1].length() - 1);
        //ezafe kardane space be hameye khoone ha joz akhari
        for (int i = 0; i < sentence.length - 1; i++) {
            sentence[i] = sentence[i].concat(" ");
        }
        makeRope(sentence, ptr);
    }

    // NEW
    public void makeRope(String[] sentence, Node ptr) {
        while (sentence.length >= 2) {
            ptr.size = numberOfLeftChars(sentence);
            ptr.lNode = new Node(0, null);
            ptr.rNode = new Node(0, null);
            String[] leftHalf = leftHalf(sentence);
            String[] rightHalf = righthalf(sentence);
            makeRope(leftHalf, ptr.lNode);
            makeRope(rightHalf, ptr.rNode);
            break;
        }
        if (sentence.length == 1) {
            ptr.string = sentence[0];
            ptr.size = sentence[0].length();
        }
    }

    public String[] leftHalf(String[] sentence) {
        String[] leftHalf = new String[(int) Math.ceil((float)sentence.length / 2)];
        for (int i = 0; i < Math.ceil((float)sentence.length / 2); i++) {
            leftHalf[i] = sentence[i];
        }
        return leftHalf;
    }

    public String[] righthalf(String[] sentence) {
        String[] righthalf = new String[sentence.length / 2];
        for (int j = 0, i = (int) Math.ceil((float)sentence.length / 2); j < sentence.length / 2; j++, i++) {
            righthalf[j] = sentence[i];
        }
        return righthalf;
    }

    public int numberOfLeftChars(String[] sentence) {
        // be dast avardane tedad character haye nimeye aval araye baraye size ptr
        int size = 0;
        for (int i = 0; i <Math.ceil((float)sentence.length / 2); i++) {
            size += sentence[i].length();
        }
        return size;
    }

    // STATUS
    public void printRope(Node ptr) {
        if (ptr != null) {
            printRope(ptr.lNode);
            if (ptr.string!=null) {
                System.out.print(ptr.string);
            }
            printRope(ptr.rNode);
        }
    }
}

















