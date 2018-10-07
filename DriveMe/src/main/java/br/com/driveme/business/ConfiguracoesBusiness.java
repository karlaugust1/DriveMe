package br.com.driveme.business;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.driveme.entity.PecaImagem;
import br.com.driveme.util.ResponseType;
import br.com.driveme.util.ServiceResponse;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ConfiguracoesBusiness {
	
	public ServiceResponse salvarImagem(Map<String, MultipartFile> arquivo) {
		
		MultipartFile file = arquivo.get("file");
	    File imagem = new File(file.getOriginalFilename());
		final String diretorio = "C:/Desenvolvimento/Workspace/code-workspace/driveme/static/pecas/";
		Integer numero = new Random().nextInt(999);
		String nomeImagem = numero + imagem.getName();
		try {
			OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(diretorio + nomeImagem));
			InputStream inputStream = new ByteArrayInputStream(arquivo.get("file").getBytes());
			int token = -1;
			while((token = inputStream.read()) != -1){
				bufferedOutputStream.write(token);
			}
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ConfiguracoesBusiness.salvarImagem()");
		}
		Map<String, Object> result = new HashMap<>();
		PecaImagem pecaImagem = new PecaImagem();
		System.out.println(nomeImagem);
		pecaImagem.setPeimUrl("/static/pecas/" + nomeImagem);
		result.put("imagem", pecaImagem);
		return new ServiceResponse(ResponseType.SUCCESS, "Imagem salva com sucesso", "Imagem salva com sucesso", result);
	}
	
	/*public File convert(Map<String, MultipartFile> arquivo)	{   
		File convFile = null;
		try {
			
			MultipartFile file = arquivo.get("file");
		    convFile = new File(file.getOriginalFilename());
			convFile.createNewFile();
		    FileOutputStream fos = new FileOutputStream(convFile); 
		    fos.write(file.getBytes());
		    fos.close(); 
		    
		} catch (IOException e) {
			System.out.println("ConfiguracoesBusiness.convert()");
			e.printStackTrace();
		} 
	    return convFile;
	}*/

}
