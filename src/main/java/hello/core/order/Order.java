package hello.core.order;

public record Order (

    Long memberId,
    String itemName,
    int itemPrice,
    int discountPrice
){
    public int getCalculatedPrice(){
        return itemPrice-discountPrice;
    }
}
