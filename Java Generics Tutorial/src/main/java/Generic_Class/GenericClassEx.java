package Generic_Class;

public class GenericClassEx<T> {

    private T coins;

    public GenericClassEx(T coins) {
        this.coins = coins;
    }


    public T getData() {
        return this.coins;
    }
}
