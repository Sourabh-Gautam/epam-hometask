package component.annotation.dependencyinjection;

import org.springframework.stereotype.Component;

@Component("blackpen")
public class BlackPen implements Pen {

	@Override
	public void writing(int rollno) {
		System.out.println("Writing rollno with BlackPen - "+rollno);
	}

}
