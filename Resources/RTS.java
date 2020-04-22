package rts;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;


public class RTS extends JFrame implements CastVote, CaretListener {

    //Buttons
    JButton CastVote = new JButton("Cast Vote");
    JButton login = new JButton("Login");
    JButton next = new JButton("Next");
    JButton Dashboard = new JButton("Dashboard");
    JButton exit = new JButton("Exit");
    JButton NewU = new JButton("Create New User");
    JButton home = new JButton("Home");
    JButton Log = new JButton("Sign in");
    JButton Vote = new JButton("VOTE");
    JButton C1 = new JButton("Haroon");
    JButton C2 = new JButton("AQ");
    JButton SR = new JButton("Server");

    //Labels
    JLabel UN = new JLabel("User : ");
    JLabel RegN = new JLabel("Reg No: ");
    JLabel PW = new JLabel("Password ");
    public JTextField NumberOfVotes = new JTextField();


    public JLabel U(int x, int y, boolean v) {
        UN.setBounds(x, y, 100, 20);
        UN.setVisible(v);
        return UN;
    }

    public JLabel P(int x, int y, boolean v) {
        PW.setBounds(x, y, 100, 20);
        PW.setVisible(v);
        return PW;
    }

    public JLabel Re(int x, int y, boolean v) {
        RegN.setBounds(x, y, 100, 200);
        RegN.setVisible(v);
        return RegN;
    }

    //Radio Button
    JRadioButton admin = new JRadioButton("Admin", false); //Select State Admin or User
    JRadioButton user = new JRadioButton("user", true);
    ButtonGroup BTG = new ButtonGroup(); //Button Group

    public void RadioButtons() {
        BTG.add(admin);
        BTG.add(user);
        admin.setBounds(100, 180, 100, 20);
        user.setBounds(200, 180, 100, 20);
        add(admin);
        add(user);
    }

    //JCombo Box

    JComboBox Reg = new JComboBox();

    JComboBox FA = new JComboBox();
    JComboBox Sec = new JComboBox();

    //JPanel
    JPanel J1 = new JPanel();

    //TextField
    JTextField U = new JTextField();
    JTextField P = new JPasswordField(15);

    private JTextField Username(boolean v) {
        U.setBounds(200, 100, 120, 20);
        U.setVisible(v);
        return U;
    }

    private JTextField Pass(boolean v) {
        P.setBounds(200, 150, 120, 20);
        P.setVisible(v);
        return P;
    }

    private JButton CV(boolean v) {
        CastVote.setBounds(130, 100, 200, 40);
        CastVote.setVisible(v);
        return CastVote;
    }

    private JButton SS(boolean v) {
        SR.setBounds(130, 100, 200, 40);
        SR.setVisible(v);
        return SR;
    }

    private JButton LOGIN(boolean v) {
        login.setBounds(130, 50, 200, 40);
        login.setFont(new Font("Times New Roman", 0, 20));
        login.setVisible(v);
        return login;
    }

    private JButton NEXT(boolean v) {
        next.setBounds(200, 200, 100, 50);
        next.setFont(new Font("Times New Roman", 0, 20));
        next.setVisible(v);
        return next;
    }

    private JButton EXIT(boolean v) {
        exit.setBounds(130, 250, 200, 40);
        exit.setFont(new Font("Times New Roman", 0, 20));
        return exit;
    }

    private JButton NEWUSER(boolean v) {
        NewU.setBounds(130, 200, 200, 40);
        NewU.setFont(new Font("Times New Roman", 0, 20));
        NewU.setVisible(v);
        return NewU;
    }

    private JButton DB(boolean v) {
        Dashboard.setBounds(130, 150, 200, 40);
        Dashboard.setFont(new Font("Times New Roman", 0, 10));
        Dashboard.setVisible(v);
        return Dashboard;
    }

    private JButton HM(boolean v) {
        home.setBounds(10, 10, 100, 50);
        home.setVisible(v);
        return home;
    }

    private JButton LG(boolean v) {
        Log.setBounds(100, 200, 150, 50);
        Log.setVisible(true);
        return Log;
    }

    //Server Stuff


    public static void main(String[] args) {
        new RTS();
    }


    ActionListeners a = new ActionListeners();

    public RTS() {
        initComponents();
        setLocationRelativeTo(null);

    }


    JFrame frame;

    public void initComponents() {
        mainPage();

    }

    private void BKAction() {
        this.dispose();
        new RTS();
    }

    private void NewUserAction() {
        pack();
        setSize(600, 600);
        J1.setLayout(new FlowLayout());
        J1.setBounds(180, 120, 200, 30);

        //J1.setBackground(Color.BLACK);
        LOGIN(false);
        DB(false);
        NEWUSER(false);
        CV(false);

        EXIT(true);
        add(HM(true));

        FA.addItem("FA17");
        Sec.addItem("BCS");
        for (int i = 1; i <= 50; i++) {
            Reg.addItem(new Integer(i));
        }
        J1.add(FA);
        J1.add(Sec);
        J1.add(Reg);
        add(J1);
        JLabel user = U(130, 100, true);

        add(user);
        add(NEXT(true));
        add(P(130, 150, true));
        add(Re(130, 30, true));
        add(U);
        add(Username(true));
        add(Pass(true));

    }

    Server S = new Server();

    private void nextAction() throws Exception {
        System.out.println("NA:Trying to write");
        write();
        dispose();
        new RTS();


    }


    private void loginAction() {
        pack();
        setSize(400, 500);
        setLayout(null);
        LOGIN(false);
        CV(false);
        DB(false);
        NEWUSER(false);
        EXIT(true);
        add(LG(true));
        add(U(140, 100, true));
        add(P(140, 150, true));
        add(Username(true));
        add(Pass(true));
        add(HM(true));
        RadioButtons();
    }

    public void adminF(){
        Username(false);
        Pass(false);
        UN.setVisible(false);
        PW.setVisible(false);
        LOGIN(false);
        Log.setVisible(false);
        user.setVisible(false);
        admin.setVisible(false);
        add(SS(true));


    }

    public void ServerAction(){
        new SwingWorker<Void, Void>() {
            protected Void doInBackground() throws Exception {
                S.startRunning();
                return null;
            }
        }.execute();
        System.out.println("Running");

    }

    private void sin() {
        if (UserCheck()) {
            Username(false);
            Pass(false);
            UN.setVisible(false);
            PW.setVisible(false);
            LOGIN(false);
            Log.setVisible(false);
            user.setVisible(false);
            admin.setVisible(false);

            CV(true);

        }else if (AdminCheck()) {
            adminF();
        }
        else{
                System.out.println("Wrong Passowrd");}
    }

    public void caretUpdate(CaretEvent e) {


    }

    protected void Dynamic() {


    }


    protected void CastVote() {
        pack();
        setSize(600, 600);
        CV(false);
        C1.setBounds(100, 100, 100, 50);
        add(C1);
        C2.setBounds(100, 150, 100, 50);
        add(C2);


    }


    public void mainPage() {
        frame = new JFrame("RTS"); //create instance of JFrame
        setLayout(null);
        setVisible(true);
        pack();
        setSize(600, 500);
        frame.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(LOGIN(true)); //adding button
        add(CV(false));
        add(DB(true));
        add(NEWUSER(true));
        add(EXIT(true));

        SR.addActionListener(a);
        exit.addActionListener(a);
        NewU.addActionListener(a);
        next.addActionListener(a);
        home.addActionListener(a);
        Dashboard.addActionListener(a);
        Log.addActionListener(a);
        login.addActionListener(a);
        CastVote.addActionListener(a);
        C1.addActionListener(a);
        C2.addActionListener(a);


        CastVote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CastVote();
            }
        });


    }

    public JTextField DynamicLabel(boolean v) {
        NumberOfVotes.setText(String.valueOf(Cand1));
        NumberOfVotes.setBounds(100, 200, 100, 100);
        NumberOfVotes.setVisible(v);
        return NumberOfVotes;

    }


    public void GetVotes() throws IOException, ClassNotFoundException {
        NumberOfVotes.addCaretListener(this);
        ArrayList<Votes> Votes = readAllVotes();
        System.out.println("GAllVotes:" + Votes.size());
        System.out.println(Votes.size());
        for (int i = 0; i < Votes.size(); i++) {
            System.out.println(Votes.get(i).getUName());
            System.out.println(Votes.get(i).getName());

            if (Votes.get(i).getUName().equals("Haroon")) {
                Cand1++;
            } else if (Votes.get(i).getUName().equals("AQ")) {
                Cand2++;
            }
        }
        System.out.println("C1: " + Cand1);
        System.out.println("C2: " + Cand2);
        add(DynamicLabel(true));


    }

    public void addVote(Votes V) {
        try {
            ArrayList<Votes> Votes = readAllVotes();
            System.out.println("COming from here:" + Votes.size());
            Votes.add(V);
            System.out.println("Now here:" + Votes.size());

            //out.close();

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Vote.txt"));
            for (int i = 0; i < Votes.size(); i++) {
                out.writeObject(Votes.get(i));
            }
            out.writeObject(V);
            System.out.println("After for loop:" + Votes.size());
            out.flush();
            System.out.println("Object has been Serialized");
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public ArrayList<Votes> readAllVotes() {
        ArrayList<Votes> Votes = new ArrayList<>(0);
        System.out.println("Starting RAV:" + Votes.size());
        FileInputStream file = null;
        ObjectInputStream inputStream = null;
        try {
            file = new FileInputStream("Vote.txt");
            inputStream = new ObjectInputStream(file);
            boolean EOF = false;
            while (!EOF) {
                try {
                    Votes VT = (Votes) inputStream.readObject();
                    System.out.println(VT.getUName());
                    Votes.add(VT);
                } catch (ClassNotFoundException e) {
                    System.out.println("Class Not Found");
                } catch (EOFException end) {
                    EOF = true;
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException e) {
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
            System.out.println("ReadAllVotes:" + Votes.size());
            return Votes;
        }
    }


    @Override
    public void setCandidates() {

    }

    @Override
    public void voting() {

    }

    public int Cand1;
    public int Cand2;

    Server S2 = new Server();
    public class ActionListeners implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Exit")) {
                System.exit(0);}
            else if (e.getActionCommand().equals("Create New User"))
                NewUserAction();
            else if (e.getActionCommand().equals("Next")) {
                try {
                    nextAction();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else if (e.getActionCommand().equals("Home"))
                BKAction();
            else if (e.getActionCommand().equals("Dashboard")) {
                pack();
                setSize(500, 500);
                try {
                    GetVotes();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            } else if (e.getActionCommand().equals("Login")){
                loginAction();}
            else if (e.getActionCommand().equals("Sign in"))
                sin();
            else if (e.getActionCommand().equals("Cast Vote")) {
                CastVote();
            } else if (e.getActionCommand().equals("Haroon")) {
                Votes v = new Votes(U.getText(), "Haroon");
                addVote(v);
            } else if (e.getActionCommand().equals("AQ")) {
                Votes v = new Votes(U.getText(), "AQ");
                addVote(v);
            }
            else if (e.getActionCommand().equals("Server")){
                ServerAction();

            }
        }

    }

    public void LGS() { //Login Succesful

    }

    public void SearchUser() {


    }

    boolean correct;
    boolean adminC;
    private boolean UserCheck() {
        ArrayList<NewUser> Users = readAllData();
        for (int i = 0; i < Users.size(); i++) {
            if (U.getText().equalsIgnoreCase(Users.get(i).getUsername()) && P.getText().equals(Users.get(i).getPassword()) && user.isSelected()) {
                correct = true;
                break;
            }
        }
        return correct;
    }

    private boolean AdminCheck(){
        if(U.getText().equalsIgnoreCase("Admin") && P.getText().equals("Admin") && admin.isSelected()){
            adminC = true;
        }
        return adminC;
    }



    public ObjectOutputStream out;
    public ObjectInputStream in;
    public Socket client;
    public void write() throws Exception {
        client = new Socket("192.168.100.3",6789);
        try {
            System.out.println("Starting Write");
            NewUser N = new NewUser(U.getText(), P.getText());
            System.out.println(U.getText()+"  "+P.getText());
            System.out.println("Set Client");
            out = new ObjectOutputStream(client.getOutputStream());
            System.out.println(out);
            in = new ObjectInputStream(client.getInputStream());
            out.writeObject(N);
            out.flush();
            out.close();
            in.close();
            client.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Object has been Serialized");
    }

    public ArrayList<NewUser>readAllData() {
        ArrayList<NewUser> Users = new ArrayList<>(0);
        FileInputStream file = null;
        ObjectInputStream inputStream = null;
        try {
            file = new FileInputStream("MAQ.txt");
            inputStream = new ObjectInputStream(file);
            boolean EOF = false;
            while (!EOF) {
                try {
                    NewUser N= (NewUser) inputStream.readObject();
                    Users.add(N);

                }catch (ClassNotFoundException e) {
                    System.out.println("Class Not Found");
                }
                catch (EOFException end) {
                    EOF = true;
                }
            }
        }catch (FileNotFoundException ex){
        }catch (IOException e) {
        }
        finally {
            try {
                if(inputStream != null)
                    inputStream.close();
            }catch (FileNotFoundException e){
                System.out.println("File Not Found");
            }
            catch (IOException e){
                System.out.println("IO Exception while closing file");
            }
            return Users;
        }}


        public void displayUsers(){
        ArrayList<NewUser> User = readAllData();
        for (int i = 0; i < User.size(); i++) {
            System.out.println(User.get(i).getUsername());
        }
    }
}





