package MyAPIs;

public class ResourcePath {
	public static final String Create_User_Path = "/api/users";
	public static final String get_list_user_path = "/api/users?page=2";

	public static String get_single_user(int id) {
		return "/api/users/" + id;
	}

	public static String getSingleUser() {
		return "/api/users/";
	}
}
