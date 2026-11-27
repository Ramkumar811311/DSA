class Solution {
    static class Pair {
        double g;
        int ind;

        Pair(double g, int ind) {
            this.g = g;
            this.ind = ind;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.g, a.g));
        for (int i = 0; i < n; i++) {
            double oldPr = (double) classes[i][0] / classes[i][1];
            double newPr = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            pq.add(new Pair(newPr - oldPr, i));
        }
        while (extraStudents > 0) {
            Pair p = pq.poll();
            classes[p.ind][0]++;
            classes[p.ind][1]++;
            double oldPr = (double) classes[p.ind][0] / classes[p.ind][1];
            double newPr = (double) (classes[p.ind][0] + 1) / (classes[p.ind][1] + 1);
            pq.add(new Pair(newPr - oldPr, p.ind));
            extraStudents--;

        }
        double sumOfPr = 0;
        for (int i = 0; i < n; i++) {
            sumOfPr += (double) classes[i][0] / classes[i][1];
        }
        double avgPr = sumOfPr / n;
        return avgPr;
    }
}