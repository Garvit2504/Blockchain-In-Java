import java.util.Date;


public class Block {

    public String hash;
    public String previousHash;
    private String data; // our data will be a single message
    private long timeStamp; // as number of milliseconds since 1/1/1970

//    Block Constructor
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculatedHash(); // Making sure that we do this after we set the other values
    }

    public String calculatedHash(){
        String calculatedHash = StringUtil.applySha256(
                previousHash + Long.toString(timeStamp) + data
        );

        return calculatedHash;
    }
}


