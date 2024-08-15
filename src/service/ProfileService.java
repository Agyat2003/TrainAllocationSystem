package service;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import model.Profile;

public class ProfileService {
    private Map<String, Profile> profiles;

    public ProfileService() {
        this.profiles = new HashMap<>();
    }

    // Method to register a profile and return the generated login ID
    public String registerProfile(String name, int age) {
        String loginId = generateLoginId();
        Profile profile = new Profile(loginId, name, age);
        profiles.put(loginId, profile);
        return loginId;
    }

    // Method to check if a profile exists
    public boolean isProfileExist(String loginId) {
        return profiles.containsKey(loginId);
    }

    // Method to update the profile with train and seat information
    public void updateProfileWithTrainInfo(String loginId, String trainName, String seatInfo) {
        Profile profile = profiles.get(loginId);
        if (profile != null) {
            profile.setTrainName(trainName);
            String[] seatDetails = seatInfo.split(" ");
            profile.setBoogieNumber(Integer.parseInt(seatDetails[1]));
            profile.setSeatNumber(Integer.parseInt(seatDetails[3]));
        }
    }

    // Method to get all profiles information
    public String getAllProfilesInfo() {
        StringJoiner profilesInfo = new StringJoiner("\n");

        for (Map.Entry<String, Profile> entry : profiles.entrySet()) {
            String loginId = entry.getKey();
            Profile profile = entry.getValue();

            String profileInfo = String.format(
                    "Login ID: %s\nName: %s\nAge: %d\nTrain: %s\nBoogie: %d\nSeat: %d\n",
                    loginId,
                    profile.getName(),
                    profile.getAge(),
                    profile.getTrainName(),
                    profile.getBoogieNumber(),
                    profile.getSeatNumber()
            );

            profilesInfo.add(profileInfo);
        }

        return profilesInfo.toString();
    }

    // Private method to generate a unique login ID
    private String generateLoginId() {
        return "U" + (profiles.size() + 1);
    }

    public void addProfile(Profile profile) {
        profiles.put(profile.getLoginID(), profile);
    }
}
