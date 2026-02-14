import java.util.*;
interface AuctionMediator{
    void RegisterBidder(Bidder b);
    void PlacedBid(Bidder b,int amount);
}
class AuctionHose implements AuctionMediator{
    private ArrayList<Bidder> bidderList = new ArrayList<>();

    @Override
    public void RegisterBidder(Bidder b){
        bidderList.add(b);
    }

    @Override
    public void PlacedBid(Bidder b, int amount){
        System.out.println(b.name + " placed a bid of " + amount);
        //when placed the bit need to notify other bidder
        for(Bidder othBidder:bidderList){
            // othBidder.//need to recive the bid
            if(othBidder!=b){
                 othBidder.ReciveTheBid(b.name, amount,othBidder);
            }
           
        }

    }
}
class Bidder{
    public String name; //can be made private
    private AuctionMediator AuctionHose;

    public Bidder(String name,AuctionMediator AuctionHose ){
        this.name = name;
        this.AuctionHose = AuctionHose;
    }

    public void placebid(int amount){
        AuctionHose.PlacedBid(this, amount);
    }

    public void ReciveTheBid(String name,int amount,Bidder othBidder){
        System.out.println("Bidder "+" "+name+" "+"placed a bid of amount "+amount+" "+"And i am "+othBidder.name);
    }
}
public class MediatorPattern {
    public static void main(String []abs){
        //build a auction house
        AuctionMediator auctionHose = new AuctionHose();
        //create bidder
        Bidder Mi = new Bidder("MI", auctionHose);
        Bidder Rcb = new Bidder("RCB", auctionHose);
        Bidder Csk = new Bidder("CSK", auctionHose);
    
        //now register the bidder to auction house
        auctionHose.RegisterBidder(Mi);
        auctionHose.RegisterBidder(Rcb);
        auctionHose.RegisterBidder(Csk);

        //now a place a bit through mediator
        auctionHose.PlacedBid(Rcb, 16);
        auctionHose.PlacedBid(Csk, 0);
    }
}
