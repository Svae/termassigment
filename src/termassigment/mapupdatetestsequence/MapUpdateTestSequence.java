package termassigment.mapupdatetestsequence;

import com.bitreactive.library.android.maps.model.MapUpdate;
import com.bitreactive.library.android.maps.model.Marker;
import com.bitreactive.library.android.maps.model.Polyline;
import com.bitreactive.library.android.maps.model.Position;

import no.ntnu.item.arctis.runtime.Block;

public class MapUpdateTestSequence extends Block {
	
	private int index = 0;
	private int phase = 0;

	public com.bitreactive.library.android.maps.model.MapUpdate createItem() {
		if(phase==0) {
			phase = 1;
			index = -1;
			return createGeofence();
		} else if (phase==1) {
			++ index;
			
			return createMovingMarker(index);
			
			
		} else {
			phase = 0;
			return createDeleteUpdate();
		}
	}

	private MapUpdate createGeofence() {
		MapUpdate m = new MapUpdate();
		
		Polyline polyline = new Polyline("route");
		for(int i=0; i<ROUTE.length; i++) {
			Position p = ROUTE[i];
			polyline.addPoint(p);
		}
		polyline.hue(Marker.HUE_BLUE);
		m.addPolyline(polyline);
		
		Marker start = Marker.createMarker("start").title("Start").position(ROUTE[0]).hue(Marker.HUE_BLUE);
		Marker end = Marker.createMarker("end").title("Stop").showWindow(true).position(ROUTE[ROUTE.length-1]).hue(Marker.HUE_BLUE);		
		m.addMarker(start);
		m.addMarker(end);
		
		m.setCenter(ROUTE[ROUTE.length/2]);
		m.setZoom(15);
		
		return m;
	}
	
	private MapUpdate createMovingMarker(int index) {
		MapUpdate m = new MapUpdate();
		
		Marker position = Marker.createMarker("pos").position(ROUTE[index]).hue(Marker.HUE_RED);
		m.addMarker(position);
		++ index;
		
		if(index==ROUTE.length) {
			index = 0;
			phase = 2;
		}
		
		return m;
	}
	
	private MapUpdate createDeleteUpdate() {
		MapUpdate m = new MapUpdate();
		m.setClear(true);
		return m;
	}
	
	private final static Position[] ROUTE = {
        new Position(63430481, 10392217),
        new Position(63430299, 10392288),
        new Position(63430166, 10392286),
        new Position(63430017, 10392358),
        new Position(63429835, 10392430),
        new Position(63429603, 10392538),
        new Position(63429500, 10392561),
        new Position(63429409, 10392583),
        new Position(63429324, 10392604),
        new Position(63429224, 10392613),
        new Position(63429119, 10392623),
        new Position(63429039, 10392645),
        new Position(63428934, 10392654),
        new Position(63428838, 10392675),
        new Position(63428748, 10392719),
        new Position(63428648, 10392740),
        new Position(63428563, 10392772),
        new Position(63428462, 10392816),
        new Position(63428377, 10392848),
        new Position(63428287, 10392847),
        new Position(63428202, 10392879),
        new Position(63428112, 10392889),
        new Position(63428002, 10392910),
        new Position(63427891, 10392920),
        new Position(63427786, 10392986),
        new Position(63427681, 10393018),
        new Position(63427601, 10393028),
        new Position(63427526, 10393049),
        new Position(63427500, 10393262),
        new Position(63427524, 10393486),
        new Position(63427533, 10393655),
        new Position(63427538, 10393801),
        new Position(63427603, 10393824),
        new Position(63427678, 10393848),
        new Position(63427768, 10393838),
        new Position(63427833, 10393839),
        new Position(63427913, 10393873),
        new Position(63427968, 10393897),
        new Position(63428058, 10393909),
        new Position(63428113, 10393932),
        new Position(63428158, 10393955),
        new Position(63428223, 10393956),
        new Position(63428293, 10393968),
        new Position(63428358, 10394014),
        new Position(63428414, 10394026),
        new Position(63428484, 10394027),
        new Position(63428534, 10394040),
        new Position(63428574, 10394063),
        new Position(63428629, 10394064),
        new Position(63428689, 10394065),
        new Position(63428749, 10394088),
        new Position(63428829, 10394100),
        new Position(63428874, 10394101),
        new Position(63428954, 10394113),
        new Position(63429005, 10394125),
        new Position(63429004, 10394271),
        new Position(63429004, 10394506),
        new Position(63429003, 10394741),
        new Position(63428992, 10394943),
        new Position(63428977, 10395167),
        new Position(63428971, 10395357),
        new Position(63428960, 10395581),
        new Position(63428955, 10395772),
        new Position(63428955, 10395884),
        new Position(63429020, 10395851),
        new Position(63429065, 10395818),
        new Position(63429130, 10395808),
        new Position(63429201, 10395786),
        new Position(63429261, 10395753),
        new Position(63429321, 10395721),
        new Position(63429391, 10395677),
        new Position(63429482, 10395622),
        new Position(63429582, 10395590),
        new Position(63429662, 10395568),
        new Position(63429743, 10395491),
        new Position(63429803, 10395458),
        new Position(63429888, 10395359),
        new Position(63429964, 10395348),
        new Position(63430039, 10395349),
        new Position(63430109, 10395306),
        new Position(63430195, 10395262),
        new Position(63430255, 10395195),
        new Position(63430315, 10395151),
        new Position(63430365, 10395107),
        new Position(63430376, 10395007),
        new Position(63430406, 10394873),
        new Position(63430472, 10394795),
        new Position(63430492, 10394627),
        new Position(63430497, 10394470),
        new Position(63430498, 10394291),
        new Position(63430499, 10394089),
        new Position(63430504, 10393753),
        new Position(63430505, 10393439),
        new Position(63430521, 10393171),
        new Position(63430527, 10392890)
//        new Position(63430527, 10392621),
//        new Position(63430537, 10392431),
//        new Position(63430537, 10392240),
//        new Position(63430481, 10392217)
	};
}