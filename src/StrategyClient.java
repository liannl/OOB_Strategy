public class StrategyClient{
    private Encryption encription;
    public void setEncription(final Encryption encription)
    {
        this.encription = encription;
    }

    public String execute(final String data) throws Exception {
        String result = null;
        if (encription != null) {
            result = encription.execute(data);
        }
        return result;
    }
}
