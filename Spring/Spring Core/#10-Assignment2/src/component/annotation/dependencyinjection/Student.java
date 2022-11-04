package component.annotation.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("student")
public class Student {

	@Autowired
	@Qualifier("blackpen")
	private Pen pen;
	
	private int rollno;

	public void setPen(Pen pen) {
		this.pen = pen;
	}
	
	@Value("1733321008")
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public void startWriting() {
		pen.writing(rollno);
	}

	
}
