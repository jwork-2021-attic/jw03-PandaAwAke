package S191220080;

public class SimpleSelectionSorter implements Sorter {

    private int[] a;

    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])
                    swap(i, j);
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

}
