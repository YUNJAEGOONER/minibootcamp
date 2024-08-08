package org.example.project1.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.project1.DataNotFoundException;
import org.example.project1.user.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

	private final QuestionRepository questionRepository;

	public Page<Question> getList(int page, String kw) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
		return this.questionRepository.findAllByKeyword(kw, pageable);
	}

	public Question getQuestion(Integer id) {
		Optional<Question> question = questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}

	public void create(String subject, String content, SiteUser user) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		q.setAuthor(user);
		this.questionRepository.save(q);
	}

	public void modify(Question question, String subject, String content) {
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}

	public void delete(Question question) {
		this.questionRepository.delete(question);
	}

	public void vote(Question question, SiteUser siteUser) {
		question.getVoter().add(siteUser);
		this.questionRepository.save(question);
	}

	public Page<Question> getTop5HotList() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createDate");
		Pageable pageable = PageRequest.of(0, 5, sort);
		Page<Question> questions = questionRepository.findByVoterCountGreaterThan(0, pageable);
		return questions;
		// return questions.stream()
		// 	.map(question ->
		// 		new HotQuestionDto(
		// 			question.getId(),
		// 			question.getSubject(),
		// 			(long)question.getVoter().size(),
		// 			(long)question.getAnswerList().size()
		// 		)
		// 	).toList();
	}

	public record HotQuestionDto(
		Integer questionId,
		String subject,
		Long recommendCount,
		Long commentCount
	) {
	}
}