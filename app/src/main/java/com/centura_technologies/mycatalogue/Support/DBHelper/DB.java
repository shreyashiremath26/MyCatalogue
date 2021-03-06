package com.centura_technologies.mycatalogue.Support.DBHelper;

import com.centura_technologies.mycatalogue.Activity.Model.ActivitiesModel;
import com.centura_technologies.mycatalogue.Catalogue.Model.CategoryTree;
import com.centura_technologies.mycatalogue.Catalogue.Model.InitialModel;
import com.centura_technologies.mycatalogue.Catalogue.Model.Sections;
import com.centura_technologies.mycatalogue.Leads.Model.LeadsModel;

import java.util.ArrayList;

/**
 * Created by Centura User1 on 10-08-2016.
 */
public class DB {

    private static InitialModel initialModel=new InitialModel();

    private static LeadsModel leadmodel=new LeadsModel();
    private static ArrayList<LeadsModel> leads=new ArrayList<LeadsModel>();
    private static ActivitiesModel activitymodel=new ActivitiesModel();
    private static ArrayList<ActivitiesModel> activities=new ArrayList<ActivitiesModel>();
    private static Sections cataloguemodel=new Sections();
    private static ArrayList<Sections> CategoryData=new ArrayList<Sections>();
    private static CategoryTree tree=new CategoryTree();
    private static ArrayList<CategoryTree> treelist=new ArrayList<CategoryTree>();

    public static InitialModel getInitialModel() {return initialModel;}
    public static void setInitialModel(InitialModel initialModel) {DB.initialModel = initialModel;}

    public static LeadsModel getLeadmodel() {return leadmodel;}
    public static void setLeadmodel(LeadsModel leadmodel) {DB.leadmodel = leadmodel;}
    public static ArrayList<LeadsModel> getLeads() {return leads;}
    public static void setLeads(ArrayList<LeadsModel> leads) {DB.leads = leads;}

    public static ActivitiesModel getActivitymodel() {return activitymodel;}
    public static void setActivitymodel(ActivitiesModel activitymodel) {DB.activitymodel = activitymodel;}
    public static ArrayList<ActivitiesModel> getActivities() {return activities;}
    public static void setActivities(ArrayList<ActivitiesModel> activities) {DB.activities = activities;}

    public static ArrayList<Sections> getCategoryData() {return CategoryData;}
    public static void setCategoryData(ArrayList<Sections> categoryData) {CategoryData = categoryData;}
    public static Sections getCataloguemodel() {return cataloguemodel;}
    public static void setCataloguemodel(Sections cataloguemodel) {DB.cataloguemodel = cataloguemodel;}

    public static CategoryTree getTree() {
        return tree;
    }

    public static void setTree(CategoryTree tree) {
        DB.tree = tree;
    }

    public static ArrayList<CategoryTree> getTreelist() {
        return treelist;
    }

    public static void setTreelist(ArrayList<CategoryTree> treelist) {
        DB.treelist = treelist;
    }

    public static void AddLead(LeadsModel newlead){
        //Validate model
        leads.add(newlead);
    }
    public static void UpdateLead(LeadsModel editlead){
        //Validate model
        leads.add(editlead);
    }

    public static void AddActivity(ActivitiesModel newactivity){
        //Validate model
        activities.add(newactivity);
    }
    public static void EditActivity(ActivitiesModel editactivity){
        //Validate model
        activities.add(editactivity);
    }

}
