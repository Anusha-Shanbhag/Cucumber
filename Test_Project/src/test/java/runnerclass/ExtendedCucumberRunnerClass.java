package runnerclass;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import cucumber.api.junit.Cucumber;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ExtendedCucumberRunnerClass extends Runner {

	private Class clazz;
	private Cucumber cucumber;
	public static final String configPptPath = "./unilever.properties";
	public static String cycleID;

	public ExtendedCucumberRunnerClass(Class clazzValue) throws Exception {
		clazz = clazzValue;
		cucumber = new Cucumber(clazzValue);
	}

	@Override
	public Description getDescription() {
		return cucumber.getDescription();
	}

	private void runPredefinedMethods(Class annotation) throws Exception {
		if (!annotation.isAnnotation()) {
			return;
		}
		Method[] methodList = this.clazz.getMethods();
		for (Method method : methodList) {
			Annotation[] annotations = method.getAnnotations();
			for (Annotation item : annotations) {
				if (item.annotationType().equals(annotation)) {
					method.invoke(null);
					break;
				}
			}
		}
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			runPredefinedMethods(BeforeSuite.class);
			// System.out.println("In before Suite");
		} catch (Exception e) {
			e.printStackTrace();
		}
		cucumber.run(notifier);
		try {

			// connector.uploadScenarioResults("target\\cucumber.json");
			runPredefinedMethods(AfterSuite.class);

			// System.out.println("Running After Suite");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}