public class DroneLostUnique {
    public int findUniqueDeliveryId(int[] deliveryIds)
    {
        int id=0;
        for(int i=0;i<deliveryIds.length;i++)
        {
            id=id^deliveryIds[i];
        }
            return id;
    }
    public static void main(String[] args) {
        DroneLostUnique d=new DroneLostUnique();
        int[] deliveryIds={1,2,2};
        System.out.println(d.findUniqueDeliveryId(deliveryIds));
    }
}
