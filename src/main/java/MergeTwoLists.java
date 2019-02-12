import java.util.ArrayList;
import java.util.List;

public class MergeTwoLists {

    // Ecrivez une fonction qui en entrée prend deux listes triées de tailles m et n
    // et qui en sortie renvoie une liste contenant les valeurs des deux listes triées
    // Optimisez la fonction pour avoir une complexité de O(m+n)

    List<Integer> mergeTwoSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> newList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() || j < list2.size()) {
            if (i >= list1.size()) {
                newList.add(list2.get(j));
                j++;
            }
            else if (j >= list2.size()) {
                newList.add(list1.get(i));
                i++;
            }
            else if (list1.get(i) <= list2.get(j)) {
                newList.add(list1.get(i));
                i++;
            } else {
                newList.add(list2.get(j));
                j++;
            }
        }

        return newList;
    }
}
