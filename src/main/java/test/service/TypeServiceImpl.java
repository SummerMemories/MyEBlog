package test.service;


import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import test.NotFoundException;
import test.dao.TypeRepository;
import test.po.Type;


@Transactional
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

	@Override
	public Type saveType(Type type) {
		return typeRepository.save(type);
	}

	@Override
	public Type getType(Long id) {
		return typeRepository.findById(id).get();
	}

	@Override
	public Page<Type> listType(Pageable pageable) {
		return typeRepository.findAll(pageable);
	}

	@Override
	public Type updateType(Long id, Type type) {
		Type t = typeRepository.findById(id).get();
		if(t == null) {
			throw new NotFoundException("不存在该类型");
		}
		BeanUtils.copyProperties( type, t);
		return typeRepository.save(t);
	}

	@Override
	public void deleteType(Long id) {
		typeRepository.deleteById(id);
	}

	@Override
	public Type getTypeByName(String name) {
		return typeRepository.findByName(name);
	}

}