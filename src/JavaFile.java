import java.io.*;

public class JavaFile {
	int a[] = new int[100];
	int i;
	int j;
	int k;

	public void ReadFile() {
		i = 0;
		try {
			StringBuffer sb = new StringBuffer("");
			FileReader reader = new FileReader("Snake.txt");
			BufferedReader br = new BufferedReader(reader);
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str + "/n");
				a[i] = Integer.parseInt(str);
				i++;
			}
			br.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paixu() {
		this.ReadFile();
		for (j = 0; j < i; j++) {
			for (k = 0; k < i - j - 1; k++) {
				if (a[k] <= a[k + 1]) {
					int s;
					s = a[k];
					a[k] = a[k + 1];
					a[k + 1] = s;
				}
			}
		}
		File file = new File("Snake.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileWriter fw = null;
		try {
			File f = new File("Snake.txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		for (j = 0; j < i; j++) {
			if (j > 9)
				break;
			pw.println(a[j]);
		}

		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int geti() {
		this.ReadFile();
		return i;
	}

	public int[] geta() {
		this.ReadFile();
		return a;
	}
	public void jiafen(int j) {
		this.ReadFile();
		a[i] += j;
		if (i!=0&&a[i] >= a[i - 1]) {
			FileWriter fw = null;
			try {
				File f = new File("Snake.txt");
				fw = new FileWriter(f, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(fw);
			pw.println(a[i]);
			pw.flush();
			try {
				fw.flush();
				pw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(i==0){
			FileWriter fw = null;
			try {
				File f = new File("Snake.txt");
				fw = new FileWriter(f, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(fw);
			pw.println(a[i]);
			pw.flush();
			try {
				fw.flush();
				pw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.paixu();
	}
	public void qingkong(){
		File file = new File("Snake.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
