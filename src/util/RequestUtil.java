package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Request;

public class RequestUtil {
	public static Map<Integer, List<Request>> getRequestMap(List<Request> requests ) {
		List<Request> impendingRequests = new ArrayList<>();
		List<Request> paidRequests = new ArrayList<>();
		Map<Integer, List<Request>> map = new HashMap<>();
		for(Request req : requests) {
			if(req.getStatus() == 0) {
				impendingRequests.add(req);
				map.put(0, impendingRequests);
			} else {
				paidRequests.add(req);
				map.put(1, paidRequests);
			}
			
		}
		return map;
		
		
	}
}
