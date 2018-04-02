package de.westwing.androidtest.util;

import java.util.ArrayList;
import java.util.List;

import de.westwing.androidtest.model.entities.Campaigns;


public class MockModelFabric {

       public static List<Campaigns> newListOfCampaigns(int numCampaigns) {
        List<Campaigns> campaigns = new ArrayList<>(numCampaigns);

        return campaigns;
    }


}
