public class Token {
    private String tokenId;
    private String partName;
    private int quantity;

    public Token(String tokenId, String partName, String quantity){
        this.tokenId=tokenId;
        this.partName=partName;
        this.quantity=Integer.parseInt(quantity);
    }

    public String getTokenId() {
        return tokenId;
    }

    public String getPartName() {
        return partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void use(int quantity){
        this.quantity-=quantity;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenId='" + tokenId + '\'' +
                ", partName='" + partName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
