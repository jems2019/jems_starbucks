package starbucks ;

/**
 * Authentication Proxy for App Controller
 */
public class AppAuthProxy implements IApp, IPinAuthObserver {
    
    private IApp app = new AppController() ;
    private KeyPad kp;
    private Passcode pc;
    private PinScreen ps ;
    private Spacer sp ;
    private boolean authenticated = false ;
    private PinEntryMachine pm ;

    public AppAuthProxy() {
        kp = new KeyPad() ;
        pc = new Passcode() ;
        sp = new Spacer() ;
        ps = new PinScreen(new AppController()) ;
        pm = new PinEntryMachine() ;

        // setup the composite pattern
        ps.addSubComponent( pc ) ;
        ps.addSubComponent( sp ) ;
        ps.addSubComponent( kp ) ;

        // setup the observer pattern
        ((IKeyPadSubject)kp).attach( pc ) ;
        ((IKeyPadSubject)kp).attach( pm ) ;
        ((IPinAuthSubject)pm).registerObserver(this) ;


    }

    /**
    * Switch to Landscape View
    */
    public void landscape() {
        if ( authenticated )
            app.landscape() ;
    }

    /**
     * Switch to Portait View
     */
    public void portrait() {
        if ( authenticated )
            app.portrait() ;
    }

    /**
     * User Touch at X,Y Coordinates
     * @param x X Coordinate
     * @param y Y Coordinate
     */
    public void touch(int x, int y) {
//        System.err.println(app.screen());
        if ( authenticated )
            app.touch(x, y) ;
        else
            ps.touch(x, y) ;
    }

    /**
     * Display Screen Contents to Terminal
     */
    public void display() {
        System.out.println( screenContents() ) ;
    }

    /**
     * Get Class Name of Screen
     * @return Class Name of Current Screen
     */
    public String screen() {
      //  System.err.println(ps.name().toString());
        if ( authenticated ){
          //  System.err.println(app.screen());
            return app.screen();
        }
        else{
//            System.err.println("Screen: " + app.screen());
            // Set current screen to PinScreen upon unauthenticated screen
         //   AppController.getInstance().setCurrentScreen(new PinScreen());
            return ps.name() ;
        }
    }

    /**
     * Get Screen Contents as a String
     * @return Screen Contents of Current Screen
     */
    public String screenContents() {
        //System.err.println("PS Name: " + ps.name().toString());
       // System.err.println("PS Display: " + ps.display().toString());
//        System.err.println("Authenticated: " + authenticated);
        if ( authenticated ) {
            return app.screenContents() ;
        } else {
            String out = "" ;
            out = "----------------\n" ;
            out += "   " + ps.name() + "  \n" ;
          //  out += "----------------\n\n\n" ;
            out += "----------------\n" ;
            out += ps.display() ;
            out += "\n\n\n----------------\n" ;
            return out ;
        }
    }


    /**
     * Select a Menu Command
     * @param c Menu Option (A, B, C, E, or E)
     */
    public void execute( String c ) {
        if ( authenticated )
            app.execute( c ) ;
    }

    /**
     * Navigate to Previous Screen
     */
    public void prev() {
        if ( authenticated )
            app.prev() ;
    }

    /**
     * Navigate to Next Screen
     */
    public void next() {
        if ( authenticated )
            app.next() ;
    }

    /**
     * Receive Authenticated Event from Authenticator
     */
    public void authEvent() {
        this.authenticated = true ;

    }



}
