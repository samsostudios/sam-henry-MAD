package com.example.sam.lab6;

/**
 * Created by Sam on 12/4/17.
 */

public class TripLocation {
    private String location;
    private String locationPics;

    private void setLocationInfo(Integer LocationSelect){
        switch (LocationSelect){
            case 0: //America cheap (New York)
                location = "New York";
                locationPics = "https://www.google.com/search?q=new+york&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi_5rPSnfHXAhXL6oMKHeNtBQMQ_AUIDCgD&biw=1680&bih=953";
                break;
            case 1: //Europe Cheap (stockholm)
                location = "Stockholm";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=bNYlWsL6JdWojwOUvKeIAg&q=stockholm&oq=stock&gs_l=psy-ab.3.0.0l7j0i67k1l2j0.17459564.17460538.0.17461983.5.4.0.1.1.0.124.234.0j2.2.0....0...1c.1.64.psy-ab..2.3.238....0.WP-7oKgrs38";
                break;
            case 2: //Asia Cheap
                location = "Shanghai";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=K7UlWvq_FqvKjwSt7JlA&q=shanghai&oq=shang&gs_l=psy-ab.3.0.0i67k1j0l3j0i67k1j0j0i67k1j0l3.62986.63661.0.65139.5.5.0.0.0.0.56.254.5.5.0....0...1c.1.64.psy-ab..0.5.253....0.TnkARNiX2xU";
                break;
            case 3: //Africa Cheap
                location = "Cape Town";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=QNMlWu_hGZWejwO9xbvwDg&q=cape+town&oq=cape&gs_l=psy-ab.3.0.0i67k1j0j0i67k1j0l2j0i67k1j0j0i67k1l3.683630.684047.0.685497.4.4.0.0.0.0.106.374.2j2.4.0....0...1c.1.64.psy-ab..0.4.373....0.6hYFP20iO_Q";
                break;
            case 4: //Australia cheap
                location = "Sydney";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=_dUlWq6pJdPWjwPI2LOQAg&q=sydney+australia&oq=sydney+a&gs_l=psy-ab.3.0.0l10.91848.95117.0.96256.8.6.0.2.2.0.105.591.2j4.6.0....0...1c.1.64.psy-ab..0.8.598...0i67k1.0.e0aRInhThlA";
                break;
            case 5: //America expensive (Hawaii)
                location = "Honolulu";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=bbUlWs2sOoT4jwSi6JuYAg&q=hawaii&oq=hawaii&gs_l=psy-ab.3..0i67k1l2j0l8.7213916.7214791.0.7215027.6.5.0.1.1.0.106.433.4j1.5.0....0...1c.1.64.psy-ab..0.6.437....0.o-d4jfwKoeg";
                break;
            case 6: //Eurpoe Expensive (Istanbul)
                location = "Istanbul";
                locationPics = "https://www.google.com/search?tbm=isch&q=istanbul&spell=1&sa=X&ved=0ahUKEwjuj-r-ufHXAhVK9mMKHUzfCicQvwUIOygA&biw=1680&bih=953&dpr=2";
                break;
            case 7: //Asia Expensive
                location = "Mumbai";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=jdIlWoOjIMPQjwPo2Ym4Cw&q=mumbai&oq=mum&gs_l=psy-ab.3.0.0i67k1j0l2j0i67k1j0j0i67k1j0l4.169202.169715.0.171035.3.3.0.0.0.0.99.271.3.3.0....0...1c.1.64.psy-ab..0.3.270....0.s6LDGI7L3Mo";
                break;
            case 8: //Africa Expensive
                location = "Cairo";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=79UlWsfnEMOIjwPr0LnwDA&q=cairo&oq=cairo&gs_l=psy-ab.3..0i67k1j0j0i67k1l2j0l3j0i67k1l3.11046.12645.0.13049.5.5.0.0.0.0.122.410.2j2.4.0....0...1c.1.64.psy-ab..1.4.409....0.iLBr9R5drvA";
                break;
            case 9: //Australia Expensive
                location = "Perth";
                locationPics = "https://www.google.com/search?biw=1680&bih=953&tbm=isch&sa=1&ei=X9YlWpH6A4SwjwPSzrGYDA&q=Perth+australia&oq=Perth+australia&gs_l=psy-ab.3..0i67k1l2j0l8.10692.11313.0.12206.5.5.0.0.0.0.115.486.3j2.5.0....0...1c.1.64.psy-ab..0.5.485...0i7i30k1j0i10k1.0.GGtwRNo5z44";
                break;
            default:
                location = "none";
                locationPics = "https://www.google.com";
        }
    }

    public void setDestination(Integer LocationSelect){
        setLocationInfo(LocationSelect);
    }

    public void setDestURL(Integer LocationSelect){
        setLocationInfo(LocationSelect);
    }

    public String getDestenation(){
        return location;
    }

    public String getURL(){
        return locationPics;
    }
}
