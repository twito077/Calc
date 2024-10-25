package demo;

public class Calculator {
    private int state = 0;
    private int memory = 0;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void add(int value){
        state += value;
    }

    public void mult(int value){
        state *= value;
    }

    public void subtract(int value) {
        state -= value;
    }

    public void divide(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        state /= value;
    }

	//memory functions
    public void storeInMemory() {
        memory = state;
    }

    public void addFromMemory() {
        state += memory;
    }

    public void subtractFromMemory() {
        state -= memory;
    }

    public void multFromMemory() {
        state *= memory;
    }

    public void divideFromMemory() {
        if (memory == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        state /= memory;
    }
}
