package link;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import chain.Chain;

/**
 * Creating a link between chains
 */
public  class Link implements Serializable {

    public static final String LINK_CLASS = "LINK_CLASS";
    /**
     * Chain link constant
     */
    public static final String LINKS = "LINKS";

    /**
     * Chain link ID constant
     */
    private static final String LINK_ID = "link_id";

    /**
     * Chain link text constant
     */
    private static final String LINK_TEXT = "link_text";

    /**
     * Chain link instruction constant
     */
    private static final String LINK_INST = "link_instructions";

    /**
     * Constant if a chain completed
     */
    private static final String IS_COMPLETED = "isCompleted";
    /**
     * Initial link ID
     */
    private int mLinkID;

    /**
     * Initial link text
     */
    private String mLinkText;

    /**
     * Initial link instruction
     */
    private String mLinkInst;






    /**
     * Initial flag if it's the last chain
     */
    private boolean mIsCompleted;

    /**
     * Link class constructor
     *
     * @param theLinkID given link id
     * @param theLinkText given link text
     * @param theLinkInstructions given link instruction
     * @param theIsCompleted given flag if it's the last chain
     */
    public Link(int theLinkID, String theLinkText, String theLinkInstructions, boolean theIsCompleted) {

        setmLinkID(theLinkID);
        setmLinkText(theLinkText);
        setmLinkInst(theLinkInstructions);
        mIsCompleted = theIsCompleted;


    }

    public static ArrayList<Link> parseLinkJSON(String linkJSON) throws JSONException {
        ArrayList<Link> linkList = new ArrayList<Link>();
        if (linkJSON != null) {
            JSONArray arr = new JSONArray(linkJSON);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                JSONArray linkArray = obj.getJSONArray(LINKS);
                for (int j = 0; j < linkArray.length(); j++) {

                    JSONObject linkobj = linkArray.getJSONObject(j);
                    Log.i(LINK_CLASS, linkobj.toString());
                    Link newLink = new Link(linkobj.getInt(Link.LINK_ID),

                            linkobj.getString(Link.LINK_TEXT),
                            linkobj.getString(Link.LINK_INST),
                            linkobj.getBoolean(Link.IS_COMPLETED));
                    Log.i(LINK_CLASS, newLink.getmLinkInst());
                    linkList.add(newLink);
                }
            }
        }
        return linkList;
    }
    public void setmIsCompleted(boolean mIsCompleted) {
        this.mIsCompleted = mIsCompleted;
    }
    public boolean ismIsCompleted() {
        return mIsCompleted;
    }
    public int getLinkId() {
        return mLinkID;
    }

    public String getLINK_ID() {
        return LINK_ID;
    }

    public String getLINK_TEXT() {
        return LINK_TEXT;
    }

    public String getLINK_INST() {
        return LINK_INST;
    }

    public String getIS_COMPLETED() {
        return IS_COMPLETED;
    }

    public int getmLinkID() {
        return mLinkID;
    }

    public void setmLinkID(int mLinkID) {
        this.mLinkID = mLinkID;
    }

    public String getmLinkText() {
        return mLinkText;
    }

    public void setmLinkText(String mLinkText) {
        this.mLinkText = mLinkText;
    }

    public String getmLinkInst() {
        return mLinkInst;
    }

    public void setmLinkInst(String mLinkInst) {
        this.mLinkInst = mLinkInst;
    }
}