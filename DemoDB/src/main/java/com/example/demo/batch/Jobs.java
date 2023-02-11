package com.example.demo.batch;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.postgres.entity.PEntity;
import com.example.demo.postgres.repo.PRepo;

@SuppressWarnings("unused")
@Component
public class Jobs {

	private static final Logger LOGGER = LogManager.getLogger(Jobs.class);

	private static BigDecimal fixedDelayCount = BigDecimal.ZERO;

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

	@Autowired
	@Qualifier("PJDBC")
	private JdbcTemplate pJdbc;

	@Autowired
	@Qualifier("OJDBC")
	private JdbcTemplate oJdbc;

	@Autowired
	@Qualifier("PJDBC")
	private JdbcTemplate jdbc;

	@Autowired
	@Qualifier("ODS")
	private DataSource ods;

	@Autowired
	@Qualifier("PDS")
	private DataSource pds;

	@Autowired
	private PRepo pRepo;

//	@Autowired
//	private ORepo oRepo;

//	@Transactional
	@Scheduled(fixedDelay = 1000) // fixedDelay = 5000表示當前方法執行完畢5000ms後，Spring scheduling會再次呼叫該方法
	public void testFixDelay() {

		LOGGER.info("test");

		String seq = "20220310";

		Map<String, Object> map = oJdbc.queryForMap("select * from (select seq,num from demo where seq <= '" + seq
				+ "' order by seq desc) where rownum < 2");

		if (map == null) {
			LOGGER.info("null");
		} else if (map.isEmpty()) {
			LOGGER.info("empty");
			System.out.println("empty map");
		} else {
			LOGGER.info(map.get("seq"));
			LOGGER.info(map.get("num"));
		}

//		SqlRowSet rows = jdbcTemplate.queryForRowSet("select * from DEMO where SEQ='GG2'");

//		jdbc.setDataSource(ods);
//		jdbc.update("insert into DEMO (seq,num) values (?,?)", FORMATTER.format(LocalDateTime.now()), fixedDelayCount);
//		pJdbc.update("insert into DEMO (seq,num) values (?,?)", FORMATTER.format(LocalDateTime.now()), fixedDelayCount);
//		oJdbc.update("insert into DEMO (seq,num) values (?,?)", FORMATTER.format(LocalDateTime.now()), fixedDelayCount);
//		Optional<PEntity> gg = pRepo.findById("GG");
//		if (gg.isPresent()) {
//			LOGGER.info(gg.get().getNum());
//		}
//		demoRepo.save(gg.orElse(new Demo("GG", BigDecimal.ZERO)));
//
//		List<Demo> demos = demoRepo.findAll();
//		demos.stream().forEach(d -> {
//			d.setNum(d.getNum().add(BigDecimal.TEN));
//			demoRepo.save(d);
////			throw new RuntimeException();
//		});

		/*
		 * for (int i = 0; i < 10; i++) { fixedDelayCount =
		 * fixedDelayCount.add(BigDecimal.ONE); LOGGER.info(fixedDelayCount);
		 * rows.first(); LOGGER.info(rows.getBigDecimal("NUM")); jdbcTemplate.update(
		 * "insert into DEMO (SEQ,NUM) values ('" + Integer.toString(i) + "'," +
		 * Integer.toString(i) + ")"); }
		 */
	}
}
