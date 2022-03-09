public class Car{
    public int changeSpeed(int speed){
	    if (speed == 0) {
	        return 0;
	    } else {
	        if (speed > 0 && speed < 5) {
	            return 1;
	        } else {
	            if (speed > 5 && speed < 10) {
	                return 2;
	            } else {
	                if (speed > 10 && speed < 30) {
	                    return 3;
	                } else {
	                    if (speed > 30 && speed < 55) {
	                        return 4;
	                    } else {
	                        if (speed > 55 ) {
	                            return 5;
	                        }
	                    }
	                }
	            }
	        }
	    }
	    return 0;
    }
}
    
