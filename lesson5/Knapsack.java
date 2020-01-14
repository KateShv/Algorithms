package lesson5;

class Knapsack {

    private Items[] items;

    Knapsack(Items[] items) {
        this.items = items;
    }

    int bestRes(int i, int weigth) {
        if (i < 0) {
            return 0;
        }
        return (this.items[i].getWeight() > weigth) ? bestRes(i-1, weigth) : Math.max(bestRes(i-1, weigth), bestRes(i-1, weigth - this.items[i].getWeight()) + this.items[i].getCost());
    }

}
