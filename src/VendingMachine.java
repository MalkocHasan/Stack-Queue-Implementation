import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private String partFile;
    private String itemFile;
    private String tokenFile;
    private String taskFile;
    private String outputFile;
    private ArrayList<Part> parts;
    private Queue tokenBox;
    private BufferedWriter writer;

    public VendingMachine(String partFile, String itemFile, String tokenFile, String taskFile,String outputFile) throws IOException {
        this.partFile=partFile;
        this.itemFile=itemFile;
        this.tokenFile=tokenFile;
        this.taskFile=taskFile;
        this.outputFile=outputFile;
        this.parts= new ArrayList<>();
        this.tokenBox=new Queue();
        this.writer = new BufferedWriter(new FileWriter(this.outputFile,false));
    }

    /**
     *  function that place the parts, items, tokens
     */
    public void start() throws Exception {
        //reads parts file and place parts in an arraylist
        File myObj = new File(partFile);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            parts.add(new Part(myReader.nextLine()));
        }
        myReader.close();

        //reads items and place them in to the specific part
        myObj = new File(itemFile);
        myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] lineArr = line.split(" ");
            for(int i=0;i<this.parts.size();i++){
                if(lineArr[1].equals(this.parts.get(i).getName())){
                    this.parts.get(i).push(lineArr[0]);
                }
            }
        }
        myReader.close();

        //place the tokens to the token box
        ArrayList<Token> tokens = new ArrayList<>();
        myObj = new File(tokenFile);
        myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] lineArr = line.split(" ");
            tokenBox.enqueue(new Token(lineArr[0],lineArr[1],lineArr[2]));
        }
        myReader.close();
    }


    public void runTasks() throws FileNotFoundException {
        //reads parts file and place parts in an arraylist
        File myObj = new File(taskFile);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] line = myReader.nextLine().split("\t");
            String[] commands = new String[line.length-1];
            for(int i=1;i<line.length; i++){
                commands[i-1]=line[i];
            }

            switch (line[0]){
                case "BUY":
                    buy(commands);
                    break;
                case "PUT":
                    put(commands);
                    break;
                default: break;
            }
        }
        myReader.close();
    }

    private void buy(String[] commands) {
        for(String command:commands){
            String[] buying= command.split(",");
            String name=buying[0];
            int quantity=Integer.parseInt(buying[1]);
            for(int i=0;i<tokenBox.size();i++){
                if(tokenBox.get(i).getPartName().equals(name)){
                    if(tokenBox.get(i).getQuantity()>=quantity){
                        Token myToken = tokenBox.remove(i);
                        myToken.use(quantity);
                        for(int k=0;k<quantity;k++){
                            for(int z=0;z<parts.size();z++){
                                if(parts.get(z).getName().equals(name)){
                                    parts.get(z).pop();
                                }
                            }
                        }
                        if(!(myToken.getQuantity()<=0)){
                            tokenBox.enqueue(myToken);
                        }
                        break;
                    }else{
                        Token myToken = tokenBox.remove(i);
                        int useableQuantity= myToken.getQuantity();
                        myToken.use(useableQuantity);
                        for(int k=0;k<useableQuantity;k++){
                            for(int z=0;z<parts.size();z++){
                                if(parts.get(z).getName().equals(name)){
                                    parts.get(z).pop();
                                }
                            }
                        }
                        quantity-=useableQuantity;
                        if(!(myToken.getQuantity()<=0)){
                            tokenBox.enqueue(myToken);
                        }
                    }

                }
            }
        }
    }

    private void put(String[] commands) {
        for(String command:commands){
            String[] buying= command.split(",");
            String name=buying[0];
            String[] items = new String[buying.length-1];
            for(int i=1;i<buying.length; i++){
                items[i-1]=buying[i];
            }

            for(int i=0;i<this.parts.size();i++){
                if(this.parts.get(i).getName().equals(name)){
                    for(String item: items){
                        this.parts.get(i).push(item);
                    }
                    break;
                }
            }

        }
    }

    public void printOutput() throws IOException {
        //print parts
        for(Part part : this.parts){
            this.writer.write(part.getName()+":\n");
            if(part.isEmpty()){
                this.writer.write("\n");
            }
            while(!part.isEmpty()){
                this.writer.write(part.pop()+"\n");
            }

            this.writer.write("---------------\n");
        }

        //print tokens
        ArrayList<Token> tokensToPrint = new ArrayList<>();
        while(!tokenBox.isEmpty()){
            Token token= tokenBox.poll();
            tokensToPrint.add(token);
        }

        this.writer.write("Token Box:\n");
        for(int i=tokensToPrint.size()-1;i>=0;i--){
            this.writer.write(String.format("%s %s %d\n",tokensToPrint.get(i).getTokenId(),tokensToPrint.get(i).getPartName(),tokensToPrint.get(i).getQuantity()));
        }

        this.writer.close();
    }
}
