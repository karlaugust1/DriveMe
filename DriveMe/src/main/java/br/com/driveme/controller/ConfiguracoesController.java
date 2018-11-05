package br.com.driveme.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.driveme.business.ConfiguracoesBusiness;
import br.com.driveme.business.UtilBusiness;
import br.com.driveme.util.ServiceResponse;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class ConfiguracoesController {
	
	@Autowired
	ConfiguracoesBusiness business;
	
	@Autowired
	UtilBusiness utilBo;
	
	@PostMapping(value = "/configuracoes/upload")
	public ServiceResponse uploadFoto (MultipartHttpServletRequest request) throws IOException{
		Map<String, MultipartFile> arquivo = request.getFileMap();
		return business.salvarImagem(arquivo);
		
	}
	
	@GetMapping(value = {"/informacoes"})
	public ServiceResponse getInformacoesIniciais() {
		return utilBo.getInformacoesIniciais();
	}
	
/*	public static File convert(MultipartFile file) {
		File convFile = new File(file.getOriginalFilename());
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
		} catch (Exception ex) {
			throw new BusinessException(ExceptionType.VALIDATOR, "Erro ao converter arquivo", "Erro ao converter o arquivo enviado pelo navegador!");
		}	
		return convFile;
	}*/


}
