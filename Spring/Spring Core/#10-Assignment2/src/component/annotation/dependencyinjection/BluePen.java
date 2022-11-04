package component.annotation.dependencyinjection;

import org.springframework.stereotype.Component;

@Component("bluepen")
public class BluePen implements Pen {

	@Override
	public void writing(int rollno) {
		System.out.println("Writing rollno with BluePen - "+rollno);
	}

}
