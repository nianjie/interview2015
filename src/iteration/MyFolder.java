/**
 *
 */
package iteration;

import java.util.Queue;

/**
 * @author JMAS-0782
 * @param <T>
 * @param <U>
 *
 */
public class MyFolder<T, U> implements Folder<T, U> {

	@Override
	public U fold(U u, Queue<T> ts, Function2<T, U, U> function) {

        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();

//        if (ts.isEmpty()) {
//            return u;
//        } else {
//        	do {
//				u = function.apply(ts.poll(), u);
//			} while (!ts.isEmpty());
//        }
        while (!ts.isEmpty()) {
        	u = function.apply(ts.poll(), u);
        }
		return u;
	}

}
