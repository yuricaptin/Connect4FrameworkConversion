package restService.request;

public class OrderRequest {

    
    private final int itemTypeId; 
    
    public OrderRequest (int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public int GetItemTypeId() {
        return this.itemTypeId;
    }

}
