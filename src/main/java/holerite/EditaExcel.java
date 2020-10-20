package holerite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class EditaExcel {
	//seto onde está o arquivo
	private static final String fileName = "C:\\Users\\maria\\OneDrive\\Documentos\\GitHub\\projeto-folks\\src\\main\\resources\\Holerite.xls";

	public static void main(String[] args) throws IOException {
		//VAR
		String nomeFuncionario = "";
		String setorFuncionario = "";

		float salarioFuncionario = 0;

		try {
			FileInputStream file = new FileInputStream(new File(EditaExcel.fileName));

			// cria o ambiente de trabalho doe excel
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// seta que a 'folha' que sera modificada, é a primeira (começa em 0)
			HSSFSheet sheetHole = workbook.getSheetAt(0);

			// seta a linha de modificação do mês de vigência da holerite (começa em 0)
			Row rowMonth = sheetHole.getRow(1);

			// seta a linha de modificação dos funcionarios (começa em 0)
			Row rowFunc = sheetHole.getRow(5);

			// seta que coluna da linha de modificação do mês de vigência da holerite sera
			// modificada (começa em 0)
			Cell cellMonth = rowMonth.getCell(6);

			// seta que coluna da linha de modificação dos funcionarios sera
			// modificada (começa em 0)
			Cell cellFuncionario = rowFunc.getCell(1);

			// seta que coluna da linha de modificação dos funcionarios sera
			// modificada (começa em 0)
			Cell cellSetor = rowFunc.getCell(2);

			// seta que coluna da linha de modificação dos funcionarios sera
			// modificada (começa em 0)
			Cell cellSalario = rowFunc.getCell(3);

			// seta que coluna da linha de modificação dos funcionarios sera
			// modificada (começa em 0)
			Cell cellINSS = rowFunc.getCell(5);

			// Altero o valor da celula já informada para o valor da variavel nome
			// (em maiusculas)
			cellFuncionario.setCellValue(nomeFuncionario.toUpperCase());

			// Altero o valor da celula já informada para o valor da variavel setor
			// (em maiusculas)
			cellSetor.setCellValue(setorFuncionario.toUpperCase());

			// Altero o valor da celula já informada para o valor da variavel salario
			cellSalario.setCellValue(salarioFuncionario);

			// Altero o valor da celula já informada para o valor da variavel salario*9%,
			// que é referente ao inss
			cellINSS.setCellValue((salarioFuncionario / 100) * 9);

			// seta o mês de vigência da holerite
			cellMonth.setCellValue("outubro/2020".toUpperCase());

			// atualiza todas as formulas do excel de todas as sheets
			HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);

			// fecho o arquivo
			file.close();

			// abro o arquivo
			FileOutputStream outFile = new FileOutputStream(new File(EditaExcel.fileName));
			// escrevo as alterações
			workbook.write(outFile);
			// fecho novamente
			outFile.close();
			System.out.println("Arquivo Excel editado com sucesso!".toUpperCase());

		} catch (FileNotFoundException e) {
			// caso não encontre
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!".toUpperCase());
		} catch (IOException e) {
			// caso haja erro durante a edição
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!".toUpperCase());
		}

	}

}
