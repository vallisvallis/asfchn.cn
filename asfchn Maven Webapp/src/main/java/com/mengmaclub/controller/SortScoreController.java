package com.mengmaclub.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.Mangoptionsmatch;
import com.mengmaclub.model.Manyrifmatch;
import com.mengmaclub.model.Turnmatchlist;
import com.mengmaclub.model.Twoptionsmatch;
import com.mengmaclub.model.Withfriendmatch;
import com.mengmaclub.service.JoinMatchTeamPeopleService;
import com.mengmaclub.service.MangoptionsmatchService;
import com.mengmaclub.service.ManyrifmatchService;
import com.mengmaclub.service.TurnMatchListService;
import com.mengmaclub.service.TwoptionsMatchService;
import com.mengmaclub.service.WithfriendmatchService;
import com.mengmaclub.util.Arith;

@Controller
public class SortScoreController {
	// 此程序 只处理 计算分数，排名等
	// 排名程序
	@Autowired
	private JoinMatchTeamPeopleService joinMatchTeamPeopleService;
	@Autowired
	private TurnMatchListService turnMatchListService;
	@Autowired
	private TwoptionsMatchService twoptionsMatchService;
	@Autowired
	private MangoptionsmatchService mangoptionsmatchService;
	@Autowired
	private ManyrifmatchService manyrifmatchService;
	@Autowired
	private WithfriendmatchService withfriendmatchService;
	/*
	 * 单轮单参数项目
	 */
	public List<Twoptionsmatch> sort(Twoptionsmatch twoptionsmatch) {
		/*
		 * 计算(每当有一个人成绩更新时 就开始重新计算所有排名)
		 */
		List<Twoptionsmatch> twoptionsmatchs = twoptionsMatchService.findWhoJoinThisMatchThisListAndHasConfirm(
				twoptionsmatch.getJoinmatch(), twoptionsmatch.getJoinlist(), twoptionsmatch.getJoingage());
		for (Twoptionsmatch twoptionsmatch2 : twoptionsmatchs) {
			double scoreOne2 = 0.0;
			double scoreTwo2 = 0.0;
			double scoreFinal2 = 0.0;
			try {
				scoreOne2 = Double.parseDouble(twoptionsmatch2.getScoreone());
			} catch (Exception e) {

				System.out.println("发现第一轮错误");
			}
			try {
				scoreTwo2 = Double.parseDouble(twoptionsmatch2.getScoretwo());
			} catch (Exception e) {

				System.out.println("发现第二轮错误");
			}
			twoptionsmatch2.setScoreonebytranslate(scoreOne2);
			System.out.println(scoreOne2);
			twoptionsmatch2.setScoretwobytranslate(scoreTwo2);
			scoreFinal2 = Arith.add(scoreOne2, scoreTwo2);
			twoptionsmatch2.setFinalscore(Double.toString(scoreFinal2));
			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatch2);
		}
		Collections.sort(twoptionsmatchs);
		int i = 1;
		for (Twoptionsmatch twoptionsmatch2 : twoptionsmatchs) {
			if (twoptionsmatchs.size() >= 8) {
				if ((i <= Math.ceil((twoptionsmatchs.size() * 0.15)))) {
					twoptionsmatch2.setReward("一等奖");
				} else if (i > (twoptionsmatchs.size() * 0.15) && i <= Math.ceil((twoptionsmatchs.size() * 0.3))) {
					twoptionsmatch2.setReward("二等奖");
				} else if (i > (twoptionsmatchs.size() * 0.3) && i <= Math.ceil((twoptionsmatchs.size() * 0.6))) {
					twoptionsmatch2.setReward("三等奖");
				} else if (i > Math.ceil((twoptionsmatchs.size() * 0.6))) {
					twoptionsmatch2.setReward("");
				}
			}
			twoptionsmatch2.setRank(i);
			i++;
			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatch2);
		}
		twoptionsmatchs = twoptionsMatchService.findWhoJoinThisMatchThisListAndHasConfirm(twoptionsmatch.getJoinmatch(),
				twoptionsmatch.getJoinlist(), twoptionsmatch.getJoingage());
		return twoptionsmatchs;
	}

	/*
	 * 单轮多参数项目
	 */
	
	public List<Mangoptionsmatch> sort(	Mangoptionsmatch mangoptionsmatch
			) {
		/*
		 * 每当有人成绩更新时 ，整体再计算一遍
		 */
		List<Mangoptionsmatch> mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(
				mangoptionsmatch.getJoinmatch(), mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
		if (mangoptionsmatch.getJoinlist() == 10) {// 美利达
			for (Mangoptionsmatch mangoptionsmatch10 : mangoptionsmatchs) {
				double oneRoundscore1 = 0.0;
				double oneRoundscore2 = 0.0;// 第一轮时间
				double twoRoundscore1 = 0.0;
				double twoRoundscore2 = 0.0;// 第二轮时间
				try {
					oneRoundscore1 = Double.parseDouble(mangoptionsmatch10.getScore1one());// 第一轮圈数
				} catch (Exception e) {

				}
				try {
					oneRoundscore2 = Double.parseDouble(mangoptionsmatch10.getScore2one());// 第一轮时间
				} catch (Exception e) {

				}
				try {
					twoRoundscore1 = Double.parseDouble(mangoptionsmatch10.getScore1two());// 第二轮圈数
				} catch (Exception e) {

				}
				try {
					twoRoundscore2 = Double.parseDouble(mangoptionsmatch10.getScore2two());// 第二轮时间
				} catch (Exception e) {

				}
				mangoptionsmatch10.setScoreonebytranslate(oneRoundscore1);// 第一轮圈数
				mangoptionsmatch10.setScoretwobytranslate(twoRoundscore1);// 第二轮圈数
				String firstNum = Double.toString(oneRoundscore1);
				String secondNum = Double.toString(twoRoundscore1);
				mangoptionsmatch10.setScorefinalone(firstNum);
				mangoptionsmatch10.setScorefinaltwo(secondNum);
				mangoptionsmatch10.setScorefinal(firstNum + "+" + secondNum);
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch10);
			}
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.ceil((mangoptionsmatchs.size() * 0.15)))) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.15) && i <= Math.ceil((mangoptionsmatchs.size() * 0.3))) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.3) && i <= Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				Mangoptionsmatchxx.setRank(i);
				i++;
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 5) {
			/*
			 * 第5个项目，蓝翔二号
			 */
			for (Mangoptionsmatch mangoptionsmatch5 : mangoptionsmatchs) {
				double firstcome = 0.0;
				double firstback = 0.0;
				double secondCome = 0.0;
				double secondBack = 0.0;
				double finaScore = 0.0;
				double firstroundD = 0.0;
				double secondroundD = 0.0;
				try {
					firstcome = Double.parseDouble(mangoptionsmatch5.getScore1one());
				} catch (Exception e) {

				}
				try {
					firstback = Double.parseDouble(mangoptionsmatch5.getScore2one());
				} catch (Exception e) {

				}
				try {
					secondCome = Double.parseDouble(mangoptionsmatch5.getScore1two());
				} catch (Exception e) {

				}
				try {
					secondBack = Double.parseDouble(mangoptionsmatch5.getScore2two());
				} catch (Exception e) {

				}
				firstroundD = Arith.add(firstcome, firstback);// 格式计算第一轮
				secondroundD = Arith.add(secondCome, secondBack);// 格式计算第二轮
				finaScore = Arith.add(firstroundD, secondroundD);// 格式计算总成绩
				mangoptionsmatch5.setScoreonebytranslate(firstroundD);
				mangoptionsmatch5.setScoretwobytranslate(secondroundD);
				String firstround = Double.toString(firstroundD);// 转换成String
				String secondround = Double.toString(secondroundD);// 转换成String
				String finalScore = Double.toString(finaScore);// 转换成String
				mangoptionsmatch5.setScorefinalone(firstround);
				mangoptionsmatch5.setScorefinaltwo(secondround);
				mangoptionsmatch5.setScorefinal(finalScore);
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch5);
			}
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.ceil((mangoptionsmatchs.size() * 0.15)))) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.15) && i <= Math.ceil((mangoptionsmatchs.size() * 0.3))) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.3) && i <= Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				Mangoptionsmatchxx.setRank(i);
				i++;
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 11) {
			/*
			 * 第11个项目 天戈
			 */
			for (Mangoptionsmatch mangoptionsmatch11 : mangoptionsmatchs) {
				double firstFly = 0.0;
				double firstcrossHole = 0.0;
				double firstcrossTime = 0.0;
				double firstWatchView = 0.0;
				double firstFlyMon = 0.0;
				double firstLoading = 0.0;
				double secondFly = 0.0;
				double secondcrossHole = 0.0;
				double secondcrossTime = 0.0;
				double secondWatchView = 0.0;
				double secondFlyMon = 0.0;
				double secondLoading = 0.0;

				double firstScore = 0.0;
				double secondScore = 0.0;
				double finalScore = 0.0;

				try {
					firstFly = Double.parseDouble(mangoptionsmatch11.getScore1one());
				} catch (Exception e) {

				}
				try {
					firstcrossHole = Double.parseDouble(mangoptionsmatch11.getScore2one());
				} catch (Exception e) {

				}
				try {
					firstcrossTime = Double.parseDouble(mangoptionsmatch11.getScore3one());
				} catch (Exception e) {

				}
				try {
					firstWatchView = Double.parseDouble(mangoptionsmatch11.getScore4one());
				} catch (Exception e) {

				}
				try {
					firstFlyMon = Double.parseDouble(mangoptionsmatch11.getScore5one());
				} catch (Exception e) {
				}
				try {
					firstLoading = Double.parseDouble(mangoptionsmatch11.getScore6one());
				} catch (Exception e) {
				}
				try {
					secondFly = Double.parseDouble(mangoptionsmatch11.getScore1two());
				} catch (Exception e) {
				}
				try {
					secondcrossHole = Double.parseDouble(mangoptionsmatch11.getScore2two());
				} catch (Exception e) {
				}
				try {
					secondcrossTime = Double.parseDouble(mangoptionsmatch11.getScore3two());
				} catch (Exception e) {
				}
				try {
					secondWatchView = Double.parseDouble(mangoptionsmatch11.getScore4two());
				} catch (Exception e) {
				}
				try {
					secondFlyMon = Double.parseDouble(mangoptionsmatch11.getScore5two());
				} catch (Exception e) {
				}
				try {
					secondLoading = Double.parseDouble(mangoptionsmatch11.getScore6two());
				} catch (Exception e) {
				}
				firstScore = Arith.add(firstFly, firstcrossHole);
				firstScore = Arith.add(firstScore, firstcrossTime);
				firstScore = Arith.add(firstScore, firstWatchView);
				firstScore = Arith.add(firstScore, firstFlyMon);
				firstScore = Arith.add(firstScore, firstLoading);
				secondScore = Arith.add(secondFly, secondcrossHole);
				secondScore = Arith.add(secondScore, secondcrossTime);
				secondScore = Arith.add(secondScore, secondWatchView);
				secondScore = Arith.add(secondScore, secondFlyMon);
				secondScore = Arith.add(secondScore, secondLoading);
				finalScore = Arith.add(firstScore, secondScore);
				mangoptionsmatch11.setScoreonebytranslate(firstScore);
				mangoptionsmatch11.setScoretwobytranslate(secondScore);
				mangoptionsmatch11.setScorefinalone(Double.toString(firstScore));
				mangoptionsmatch11.setScorefinaltwo(Double.toString(secondScore));
				mangoptionsmatch11.setScorefinal(Double.toString(finalScore));
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch11);
			}
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.ceil((mangoptionsmatchs.size() * 0.15)))) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.15) && i <= Math.ceil((mangoptionsmatchs.size() * 0.3))) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.3) && i <= Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				Mangoptionsmatchxx.setRank(i);
				i++;
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 12) {
			for (Mangoptionsmatch mangoptionsmatch12 : mangoptionsmatchs) {
				double firstFly = 0.0;
				double firstCross = 0.0;
				double firstcirInAir = 0.0;
				double firstCrossCir = 0.0;
				double firstcirOnAir = 0.0;
				double firstCrossload = 0.0;
				double firstloading = 0.0;
				try {
					firstFly = Double.parseDouble(mangoptionsmatch12.getScore1one());
				} catch (Exception e) {
				}
				try {
					firstCross = Double.parseDouble(mangoptionsmatch12.getScore2one());
				} catch (Exception e) {
				}
				try {
					firstcirInAir = Double.parseDouble(mangoptionsmatch12.getScore3one());
				} catch (Exception e) {
				}
				try {
					firstCrossCir = Double.parseDouble(mangoptionsmatch12.getScore4one());
				} catch (Exception e) {
				}
				try {
					firstcirOnAir = Double.parseDouble(mangoptionsmatch12.getScore5one());
				} catch (Exception e) {
				}
				try {
					firstCrossload = Double.parseDouble(mangoptionsmatch12.getScore6one());
				} catch (Exception e) {
				}
				try {
					firstloading = Double.parseDouble(mangoptionsmatch12.getScore7one());
				} catch (Exception e) {
				}
				double secondFly = 0.0;
				double secondCross = 0.0;
				double secondcirInAir = 0.0;
				double secondCrossCir = 0.0;
				double secondcirOnAir = 0.0;
				double secondCrossload = 0.0;
				double secondloading = 0.0;
				try {
					secondFly = Double.parseDouble(mangoptionsmatch12.getScore1two());
				} catch (Exception e) {
				}
				try {
					secondCross = Double.parseDouble(mangoptionsmatch12.getScore2two());
				} catch (Exception e) {
			}
				try {
					secondcirInAir = Double.parseDouble(mangoptionsmatch12.getScore3two());
				} catch (Exception e) {
				}
				try {
					secondCrossCir = Double.parseDouble(mangoptionsmatch12.getScore4two());
				} catch (Exception e) {
				}
				try {
					secondcirOnAir = Double.parseDouble(mangoptionsmatch12.getScore5two());
				} catch (Exception e) {
				}
				try {
					secondCrossload = Double.parseDouble(mangoptionsmatch12.getScore6two());
				} catch (Exception e) {
				}
				try {
					secondloading = Double.parseDouble(mangoptionsmatch12.getScore7two());
				} catch (Exception e) {
				}
				double firstScore = 0.0;
				double secondScore = 0.0;
				double finalScore = 0.0;
				firstScore = Arith.add(firstFly, firstCross);
				firstScore = Arith.add(firstScore, firstcirInAir);
				firstScore = Arith.add(firstScore, firstCrossCir);
				firstScore = Arith.add(firstScore, firstcirOnAir);
				firstScore = Arith.add(firstScore, firstCrossload);
				firstScore = Arith.add(firstScore, firstloading);
				secondScore = Arith.add(secondFly, secondCross);
				secondScore = Arith.add(secondScore, secondcirInAir);
				secondScore = Arith.add(secondScore, secondCrossCir);
				secondScore = Arith.add(secondScore, secondcirOnAir);
				secondScore = Arith.add(secondScore, secondCrossload);
				secondScore = Arith.add(secondScore, secondloading);
				finalScore = Arith.add(firstScore, secondScore);
				mangoptionsmatch12.setScoreonebytranslate(firstScore);
				mangoptionsmatch12.setScoretwobytranslate(secondScore);
				mangoptionsmatch12.setScorefinalone(Double.toString(firstScore));
				mangoptionsmatch12.setScorefinaltwo(Double.toString(secondScore));
				mangoptionsmatch12.setScorefinal(Double.toString(finalScore));
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch12);
			}
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.ceil((mangoptionsmatchs.size() * 0.15)))) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.15) && i <= Math.ceil((mangoptionsmatchs.size() * 0.3))) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.3) && i <= Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				Mangoptionsmatchxx.setRank(i);
				i++;
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 13) {
			for (Mangoptionsmatch mangoptionsmatch13 : mangoptionsmatchs) {
				double firstHelpScore = 0.0;
				double firstloading = 0.0;
				double secondHelpScore = 0.0;
				double secondloading = 0.0;
				double firstScore = 0.0;
				double secondScore = 0.0;
				double finalScore = 0.0;
				try {
					firstHelpScore = Double.parseDouble(mangoptionsmatch13.getScore1one());
				} catch (Exception e) {

				}
				try {
					firstloading = Double.parseDouble(mangoptionsmatch13.getScore2one());
				} catch (Exception e) {

				}
				try {
					secondHelpScore = Double.parseDouble(mangoptionsmatch13.getScore1two());
				} catch (Exception e) {

				}
				try {
					secondloading = Double.parseDouble(mangoptionsmatch13.getScore2two());
				} catch (Exception e) {

				}

				firstScore = Arith.add(firstHelpScore, firstloading);
				secondScore = Arith.add(secondHelpScore, secondloading);
				finalScore = Arith.add(firstScore, secondScore);

				mangoptionsmatch13.setScoreonebytranslate(firstScore);
				mangoptionsmatch13.setScoretwobytranslate(secondScore);
				mangoptionsmatch13.setScorefinalone(Double.toString(firstScore));
				mangoptionsmatch13.setScorefinaltwo(Double.toString(secondScore));

				mangoptionsmatch13.setScorefinal(Double.toString(finalScore));
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch13);

			}	Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.ceil((mangoptionsmatchs.size() * 0.15)))) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.15) && i <= Math.ceil((mangoptionsmatchs.size() * 0.3))) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if (i > (mangoptionsmatchs.size() * 0.3) && i <= Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.ceil((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				Mangoptionsmatchxx.setRank(i);
				i++;
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;

		} else if (mangoptionsmatch.getJoinlist() == 14) {
			for (Mangoptionsmatch mangoptionsmatch14 : mangoptionsmatchs) {

			}

		}

		return null;

	}

	/*
	 * 批次项目
	 */
	public List<Turnmatchlist> sort(Turnmatchlist turnmatchlist){
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		List<Turnmatchlist> turnmatchlists=turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(), turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
		if (turnmatchlist.getJoinlist()==17 || turnmatchlist.getJoinlist()==18) {
			/*
			 *  F3K F3K-U12
			 */
			for (Turnmatchlist turnmatchlist17 : turnmatchlists) {
				double firstfly = 0;
				double secondfly = 0;
				double thirdfly = 0;
				double finalfly = 0;
				
				try {
					firstfly=Double.parseDouble(turnmatchlist17.getOneturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					secondfly=Double.parseDouble(turnmatchlist17.getOneturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					thirdfly=Double.parseDouble(turnmatchlist17.getOneturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					finalfly=Double.parseDouble(turnmatchlist17.getTwoturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				double firstScore=0.0;
				double secondScore=finalfly;
				System.out.println("==================F3K"+firstfly+"+"+secondfly+"+"+thirdfly);
				
				firstScore=Arith.add(firstfly, secondfly);
				firstScore=Arith.add(firstScore, thirdfly);
				turnmatchlist17.setOneturnscore(Double.toString(firstScore));
				turnmatchlist17.setTwoturnscore(Double.toString(secondScore));//两轮原始分录入完毕
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlist17);
				
			}
			/*
			 * 根据第一轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclac(turnmatchlists);
			/*
			 * 根据第2轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclacinTwo(turnmatchlists);
			/*
			 * 总换算分排序
			 */
			/*
			 * 最终德妃
			 * 
			 */
			//Turnmatchlist finaltTurnmatchlist=turnMatchListService.findBySnJid(turnmatchlist.getSn(), turnmatchlist.getJoinpeopleid());
			
				Collections.sort(turnmatchlists);
			int i = 1;
			for (Turnmatchlist turnmatchlistxx : turnmatchlists) {
				if (turnmatchlists.size() >= 8) {
					if ((i <= Math.ceil((turnmatchlists.size() * 0.15)))) {
						turnmatchlistxx.setReward("一等奖");
					} else if (i > (turnmatchlists.size() * 0.15) && i <= Math.ceil((turnmatchlists.size() * 0.3))) {
						turnmatchlistxx.setReward("二等奖");
					} else if (i > (turnmatchlists.size() * 0.3) && i <= Math.ceil((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("三等奖");
					} else if (i > Math.ceil((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("");
					}
				}
				turnmatchlistxx.setRankfinal(i);
				i++;
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlistxx);
			}
			turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(),
					turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
			return turnmatchlists;
			
			
		}else if(turnmatchlist.getJoinlist()==23){
			for (Turnmatchlist turnmatchlist23 : turnmatchlists) {
				/*
				 * S8C
				 */
				double firstSkyTime=0.0;
				double firstLoading=0.0;
				double secondSkyTime=0.0;
				double secondLoading=0.0;
				
				try {
					firstLoading=Double.parseDouble(turnmatchlist23.getOneturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					firstSkyTime=Double.parseDouble(turnmatchlist23.getOneturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondSkyTime=Double.parseDouble(turnmatchlist23.getTwoturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondLoading=Double.parseDouble(turnmatchlist23.getTwoturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				double oneturnscore=0.0;
				double twoturnscore=0.0;
				
				oneturnscore=Arith.add(firstLoading*0.25,firstSkyTime*0.75 );
				twoturnscore=Arith.add(secondLoading*0.25, secondSkyTime*0.75);
				
				turnmatchlist23.setOneturnscore(Double.toString(oneturnscore));
				turnmatchlist23.setTwoturnscore(Double.toString(twoturnscore));
				
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlist23);
				
			}
			
			/*
			 * 根据第一轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclac(turnmatchlists);
			/*
			 * 根据第2轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclacinTwo(turnmatchlists);
			
			
			/*
			 * 最终得分
			 */
			
			
			
			/*
			 * 总换算分排序
			 */
			
				Collections.sort(turnmatchlists);
			int i = 1;
			for (Turnmatchlist turnmatchlistxx : turnmatchlists) {
				if (turnmatchlists.size() >= 8) {
					if ((i <= Math.ceil((turnmatchlists.size() * 0.15)))) {
						turnmatchlistxx.setReward("一等奖");
					} else if (i > (turnmatchlists.size() * 0.15) && i <= Math.ceil((turnmatchlists.size() * 0.3))) {
						turnmatchlistxx.setReward("二等奖");
					} else if (i > (turnmatchlists.size() * 0.3) && i <= Math.ceil((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("三等奖");
					} else if (i > Math.ceil((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("");
					}
				}
				turnmatchlistxx.setRankfinal(i);
				i++;
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlistxx);
			}
			turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(),
					turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
			return turnmatchlists;
		}else if(turnmatchlist.getJoinlist()==26 ||turnmatchlist.getJoinlist()==27|turnmatchlist.getJoinlist()==29||turnmatchlist.getJoinlist()==31){
			for (Turnmatchlist turnmatchlist26 : turnmatchlists) {
				double firstSkyTime=0.0;
				double firstPointMeter=0.0;
				double firstPowertime=0.0;
				double firstScore=0.0;
				double secondSkyTime=0.0;
				double secondPointMeter=0.0;
				double secondPowertime=0.0;
				double secondScore=0.0;
				try {
					firstSkyTime=Double.parseDouble(turnmatchlist26.getOneturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					firstPointMeter=Double.parseDouble(turnmatchlist26.getOneturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					firstPowertime=Double.parseDouble(turnmatchlist26.getOneturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondSkyTime=Double.parseDouble(turnmatchlist26.getTwoturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondPointMeter=Double.parseDouble(turnmatchlist26.getTwoturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondPowertime=Double.parseDouble(turnmatchlist26.getTwoturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (turnmatchlist.getJoinlist()==26) {
				double firstPointMeterScore =100-4*firstPointMeter;//定点着陆分
				double secondPointMeterScore=100-4*secondPointMeter;
					if (firstPointMeterScore<0 ||firstPointMeter>50) {
						firstPointMeterScore=0;
					}
					if(secondPointMeterScore<0 ||secondPointMeter>50){
						secondPointMeterScore=0;
					}
				double firstSkyTimeScore=	firstSkyTime;
				
				if (firstSkyTime>180 &&firstSkyTime<=210) {
					firstSkyTimeScore=180-(firstSkyTime-180);
				}else if(firstSkyTime<=180 &&firstSkyTime>=30){
					 firstSkyTimeScore=	firstSkyTime;
				}else if(firstSkyTime<30 ||firstSkyTime>210){
					 firstSkyTimeScore=	0;
				}
					firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
					double secondSkyTimeScore=	secondSkyTime;
					
					if (secondSkyTime>180 &&secondSkyTime<=210) {
						secondSkyTimeScore=180-(secondSkyTime-180);
					}else if(secondSkyTime<=180 &&secondSkyTime>=30){
						 secondSkyTimeScore=	secondSkyTime;
					}else if(secondSkyTime<30 ||secondSkyTime>210){
						 secondSkyTimeScore=	0;
					}
						secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);	
				}else if(turnmatchlist.getJoinlist()==27){
					double firstPointMeterScore =100-4*firstPointMeter;//定点着陆分
					double secondPointMeterScore=100-4*secondPointMeter;
						if (firstPointMeterScore<0 ||firstPointMeter>50) {
							firstPointMeterScore=0;
						}
						if(secondPointMeterScore<0 ||secondPointMeter>50){
							secondPointMeterScore=0;
						}
					double firstSkyTimeScore=	firstSkyTime;
					
					if (firstSkyTime>120 &&firstSkyTime<=150) {
						firstSkyTimeScore=120-(firstSkyTime-120);
					}else if(firstSkyTime<=120 &&firstSkyTime>=30){
						 firstSkyTimeScore=	firstSkyTime;
					}else if(firstSkyTime<30 ||firstSkyTime>150){
						 firstSkyTimeScore=	0;
					}
						firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
						double secondSkyTimeScore=	secondSkyTime;
						
						if (secondSkyTime>120 &&secondSkyTime<=150) {
							secondSkyTimeScore=120-(secondSkyTime-120);
						}else if(secondSkyTime<=120 &&secondSkyTime>=30){
							 secondSkyTimeScore=	secondSkyTime;
						}else if(secondSkyTime<30 ||secondSkyTime>150){
							 secondSkyTimeScore=	0;
						}
							secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);	
					
					
				}else if(turnmatchlist.getJoinlist()==29){
					
					double firstPointMeterScore =100-4*firstPointMeter;//定点着陆分
					double secondPointMeterScore=100-4*secondPointMeter;
					double firstPowerTimeScore=firstPowertime;
					double secondPowerTimeScore=secondPowertime;
					if (firstPointMeterScore<0 ||firstPointMeter>50 ||firstPointMeter==0) {
						firstPointMeterScore=0;
					}
					if (secondPointMeterScore<0 ||secondPointMeter>50||secondPointMeter==0) {
						secondPointMeterScore=0;
					}
					double firstSkyTimeScore=	firstSkyTime;
					if (firstSkyTime>300 && firstSkyTime<=330) {
						firstSkyTimeScore=300-(firstSkyTime-300);
					}else if(firstSkyTime <= 300 && firstSkyTime >= 30){
						firstSkyTimeScore=firstSkyTime;
					}else if(firstSkyTime < 30 || firstSkyTime > 330){
						firstSkyTimeScore=0;
					}
					firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
					firstScore=Arith.sub(firstScore, firstPowerTimeScore);
					double secondSkyTimeScore=	secondSkyTime;
					if (secondSkyTime>300 && secondSkyTime<=330) {
						secondSkyTimeScore=300-(secondSkyTime-300);
					}else if(secondSkyTime <= 300 && secondSkyTime >= 30){
						secondSkyTimeScore=secondSkyTime;
					}else if(secondSkyTime < 30 || secondSkyTime > 330){
						secondSkyTimeScore=0;
					}
					secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);
					secondScore=Arith.sub(secondScore, secondPowerTimeScore);
				}else if(turnmatchlist.getJoinlist()==31){
					double firstPointMeterScore =100-(firstPointMeter/10);//定点着陆分
					double secondPointMeterScore=100-(secondPointMeter/10);	
					if (firstPointMeterScore<0) {
						firstPointMeterScore=0;
					}
					if (secondPointMeterScore<0) {
						secondPointMeterScore=0;
					}
					double firstSkyTimeScore=	firstSkyTime;
					if (firstSkyTime > 360 && firstSkyTime <= 390) {
						firstSkyTimeScore=360-(firstSkyTime-360);
					}else if(firstSkyTime<=360){
						firstSkyTimeScore=firstSkyTime;
					}else if(firstSkyTime>390){
						firstSkyTimeScore=0;
					}
					firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
					double secondSkyTimeScore=	secondSkyTime;
					if (secondSkyTime > 360 && secondSkyTime <= 390) {
						secondSkyTimeScore=360-(secondSkyTime-360);
					}else if(secondSkyTime<=360){
						secondSkyTimeScore=secondSkyTime;
					}else if(secondSkyTime>390){
						secondSkyTimeScore=0;
					}
					secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);
				}
				
			turnmatchlist26.setOneturnscore(Double.toString(firstScore));
			turnmatchlist26.setTwoturnscore(Double.toString(secondScore));
			}
			/*
			 * 根据第一轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclac(turnmatchlists);
			/*
			 * 根据第2轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclacinTwo(turnmatchlists);
			/*
			 * 总换算分排序
			 */
				Collections.sort(turnmatchlists);
			int i = 1;
			for (Turnmatchlist turnmatchlistxx : turnmatchlists) {
				if (turnmatchlists.size() >= 8) {
					if ((i <= Math.ceil((turnmatchlists.size() * 0.15)))) {
						turnmatchlistxx.setReward("一等奖");
					} else if (i > (turnmatchlists.size() * 0.15) && i <= Math.ceil((turnmatchlists.size() * 0.3))) {
						turnmatchlistxx.setReward("二等奖");
					} else if (i > (turnmatchlists.size() * 0.3) && i <= Math.ceil((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("三等奖");
					} else if (i > Math.ceil((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("");
					}
				}
				turnmatchlistxx.setRankfinal(i);
				i++;
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlistxx);
			}
			turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(),
					turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
			return turnmatchlists;
		}
		return null;
	}
	public List<Turnmatchlist> sortTurnmatchlistclac(List<Turnmatchlist> list) {
		Collections.sort(list, new Comparator<Turnmatchlist>() {
			@Override
			public int compare(Turnmatchlist o1, Turnmatchlist o2) {
				double firstRoundScore1 = Double.parseDouble(o1.getOneturnscore());
				double firstRoundScore2 = Double.parseDouble(o2.getOneturnscore());
				double result=firstRoundScore2-firstRoundScore1;		
			return (int) Math.ceil(result);
			}
		});
		
		int i = 1;
		double bestyuanshifen=0;
		for (Turnmatchlist turnmatchlist : list) {
			if (i==1) {
				
				bestyuanshifen=Double.parseDouble(turnmatchlist.getOneturnscore());
				turnmatchlist.setScoreinoneturnhascalc(1000.0);
			}
			double myclacScore=Arith.div(Double.parseDouble(turnmatchlist.getOneturnscore()), bestyuanshifen, 2);
			turnmatchlist.setScoreinoneturnhascalc(myclacScore);
			turnmatchlist.setRank1(i);
			double finalScore=Arith.add(turnmatchlist.getScoreinoneturnhascalc(), turnmatchlist.getScoreintwoturnhascalc());
			System.out.println("第一轮换算分："+turnmatchlist.getScoreinoneturnhascalc());
			System.out.println("第二轮换算分："+turnmatchlist.getScoreintwoturnhascalc());
			turnmatchlist.setFinalscore(Double.toString(finalScore));
			System.out.println("两轮打完，总成绩是："+turnmatchlist.getFinalscore());
			turnMatchListService.updateByPrimaryKeySelective(turnmatchlist);
			i++;
		}		
		return list;	
	}
	public List<Turnmatchlist> sortTurnmatchlistclacinTwo(List<Turnmatchlist> list) {
		Collections.sort(list, new Comparator<Turnmatchlist>() {
			@Override
			public int compare(Turnmatchlist o1, Turnmatchlist o2) {
				double secondRoundScore1 = Double.parseDouble(o1.getTwoturnscore());
				double secondRoundScore2 = Double.parseDouble(o2.getTwoturnscore());
				double result=secondRoundScore2-secondRoundScore1;
			return (int) Math.ceil(result);
			}
		});
		int i = 1;
		double bestyuanshifen=0;
		for (Turnmatchlist turnmatchlist : list) {
			if (i==1) {
				bestyuanshifen=Double.parseDouble(turnmatchlist.getTwoturnscore());
				turnmatchlist.setScoreintwoturnhascalc(1000.0);
			}
			double myclacScore=Arith.div(Double.parseDouble(turnmatchlist.getTwoturnscore()), bestyuanshifen, 2);
			turnmatchlist.setScoreintwoturnhascalc(myclacScore);
			turnmatchlist.setRank2(i);
			
			double finalScore=Arith.add(turnmatchlist.getScoreinoneturnhascalc(), turnmatchlist.getScoreintwoturnhascalc());
			System.out.println("第一轮换算分："+turnmatchlist.getScoreinoneturnhascalc());
			System.out.println("第二轮换算分："+turnmatchlist.getScoreintwoturnhascalc());
			turnmatchlist.setFinalscore(Double.toString(finalScore));
			System.out.println("两轮打完，总成绩是："+turnmatchlist.getFinalscore());
			turnMatchListService.updateByPrimaryKeySelective(turnmatchlist);
			
			i++;
		}		
		
		
		
		
		return list;
		
	}
	
	/*
	 * 多队友项目
	 */
	public List<Withfriendmatch> sort(Withfriendmatch withfriendmatch){
		List<Withfriendmatch>  withfriendmatchs=withfriendmatchService.findWhoJoinThisMatchThisListAndHasConfirm(withfriendmatch.getJoinmatch(), withfriendmatch.getJoinlist(), withfriendmatch.getJoingagae());
		List<Withfriendmatch> withfriendmatchsneedTosort=new ArrayList<Withfriendmatch>();
		String tempFriendId=null;
		//int i=0;
		for (Withfriendmatch withfriendmatch2 : withfriendmatchs) {
			if (!(withfriendmatch2.getMyteamfriend().equals(tempFriendId))) {
				withfriendmatchsneedTosort.add(withfriendmatch2);
			}
			tempFriendId=withfriendmatch2.getMyteamfriend();
		}
		for (Withfriendmatch withfriendmatch2 : withfriendmatchs) {
			String score1string = withfriendmatch2.getScoreone();
			String score2string = withfriendmatch2.getScoretwo();
			String[] score1old = null;
			String[] score2old = null;
			double score1 = 0;
			double score2 = 0;
			double score11 = 0;
			double score12 = 0;

			if (score1string.contains("+")) {
				score1old = score1string.split("\\+");
				if (score1old[1].endsWith("a") || score1old[1].endsWith("A") || score1old[1].endsWith("B")
						|| score1old[1].endsWith("b") || score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
					if (score1old[1].endsWith("a") || score1old[1].endsWith("A")) {
						score11 = 0.1;

					} else if (score1old[1].endsWith("B") || score1old[1].endsWith("b")) {
						score11 = 0.2;
					} else if (score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
						score11 = 0.3;
					}

					score1 = Double.parseDouble(score1old[0]) + score11;
		
				}
			} else if (!score1string.contains("+")) {

				score1 = Double.parseDouble(score1string);

			}
			withfriendmatch2.setScoreonebytranslate(score1);
			if (score2string.contains("+")) {
				score2old = score2string.split("\\+");
				if (score2old[1].endsWith("a") || score2old[1].endsWith("A") || score2old[1].endsWith("B")
						|| score2old[1].endsWith("b") || score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
					if (score2old[1].endsWith("a") || score2old[1].endsWith("A")) {
						score12 = 0.1;

					} else if (score2old[1].endsWith("B") || score2old[1].endsWith("b")) {
						score12 = 0.2;
					} else if (score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
						score12 = 0.3;
					}

					score2 = Double.parseDouble(score2old[0]) + score12;
				}
			} else if (!score2string.contains("+")) {
				score2 = Double.parseDouble(score2string);

			}
			withfriendmatch2.setScoretwobytranslate(score2);
			withfriendmatch2.setFinalscore(Double.toString(score1 + score2));
			withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch2);
			
		}
		Collections.sort(withfriendmatchsneedTosort);
		int i = 1;
		for (Withfriendmatch withfriendmatch2 : withfriendmatchsneedTosort) {
			if (withfriendmatchs.size() >= 8) {
				if ((i <= Math.ceil((withfriendmatchs.size() * 0.15)))) {
					withfriendmatch2.setReward("一等奖");
				} else if (i > (withfriendmatchs.size() * 0.15) && i <= Math.ceil((withfriendmatchs.size() * 0.3))) {
					withfriendmatch2.setReward("二等奖");
				} else if (i > (withfriendmatchs.size() * 0.3) && i <= Math.ceil((withfriendmatchs.size() * 0.6))) {
					withfriendmatch2.setReward("三等奖");
				} else if (i > Math.ceil((withfriendmatchs.size() * 0.6))) {
					withfriendmatch2.setReward("");
				}
			}
			withfriendmatch2.setRank(i);
			i++;
			withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch2);
		}
		withfriendmatchs = withfriendmatchService.findWhoJoinThisMatchThisListAndHasConfirm(withfriendmatch.getJoinmatch(),
				withfriendmatch.getJoinlist(), withfriendmatch.getJoingagae());
		return withfriendmatchs;
	}
	/*
	 * 多裁判项目
	 */
	public List<Manyrifmatch> sort(Manyrifmatch manyrifmatch){
		List<Manyrifmatch> manyrifmatchs=manyrifmatchService.findWhoJoinThisMatchThisListAndHasConfirm(manyrifmatch.getJoinmatch(), manyrifmatch.getJoinlist(), manyrifmatch.getJoingage());
	for (Manyrifmatch manyrifmatch2 : manyrifmatchs) {
		double score1one1rid=0;
		try {
			score1one1rid=Double.parseDouble(manyrifmatch2.getScore1one1rid());
		} catch (Exception e) {
			score1one1rid=0.0;
		}
		double score2one1rid=0;
		try {
			score2one1rid=Double.parseDouble(manyrifmatch2.getScore2one1rid());
		} catch (Exception e) {
			score2one1rid=0.0;
		}
		double score3one1rid=0;
		try {
			score3one1rid=Double.parseDouble(manyrifmatch2.getScore3one1rid());
		} catch (Exception e) {
			score3one1rid=0.0;
		}
		double score4one1rid=0;
		try {
			score4one1rid=Double.parseDouble(manyrifmatch2.getScore4one1rid());
		} catch (Exception e) {
			score4one1rid=0;
		}
		double score5one1rid=0;
		try {
			score5one1rid=Double.parseDouble(manyrifmatch2.getScore5one1rid());
		} catch (Exception e) {
			score5one1rid=0;
		}
		double score6one1rid=0;
		try {
			score6one1rid=Double.parseDouble(manyrifmatch2.getScore6one1rid());
		} catch (Exception e) {
			score6one1rid=0;
		}
		double score7one1rid=0;
		try {
			score7one1rid=Double.parseDouble(manyrifmatch2.getScore7one1rid());
		} catch (Exception e) {
			score7one1rid=0;
		}
		double score8one1rid=0;
		try {
			score8one1rid=Double.parseDouble(manyrifmatch2.getScore8one1rid());
		} catch (Exception e) {
			score8one1rid=0;
		}
		double score9one1rid=0;
		try {
			score9one1rid=Double.parseDouble(manyrifmatch2.getScore9one1rid());
		} catch (Exception e) {
			score9one1rid=0;
		}
		double score10one1rid=0;
		try {
			score10one1rid=Double.parseDouble(manyrifmatch2.getScore10one1rid());
		} catch (Exception e) {
			score10one1rid=0;
		}
		double score11one1rid=0;
		try {
			score11one1rid=Double.parseDouble(manyrifmatch2.getScore11one1rid());
		} catch (Exception e) {
			score11one1rid=0;
		}
		double score12one1rid=0;
		try {
			score12one1rid=Double.parseDouble(manyrifmatch2.getScore12one1rid());
		} catch (Exception e) {
			score12one1rid=0;
		}
		double score13one1rid=0;
		try {
			score13one1rid=Double.parseDouble(manyrifmatch2.getScore13on1erid());
		} catch (Exception e) {
			score13one1rid=0;
		}
		double score14one1rid=0;
		try {
			score14one1rid=Double.parseDouble(manyrifmatch2.getScore14one1rid());
		} catch (Exception e) {
			score14one1rid=0;
		}
		double score15one1rid=0;
		try {
			score15one1rid=Double.parseDouble(manyrifmatch2.getScore15one1rid());
		} catch (Exception e) {
			score15one1rid=0;
		}
		double score16one1rid=0;
		try {
			score16one1rid=Double.parseDouble(manyrifmatch2.getScore16one1rid());
		} catch (Exception e) {
			score16one1rid=0;
		}
		double score1one2rid=0;
		try {
			score1one2rid=Double.parseDouble(manyrifmatch2.getScore1one2rid());
		} catch (Exception e) {
			score1one2rid=0.0;
		}
		double score2one2rid=0;
		try {
			score2one2rid=Double.parseDouble(manyrifmatch2.getScore2one2rid());
		} catch (Exception e) {
			score2one2rid=0.0;
		}
		double score3one2rid=0;
		try {
			score3one2rid=Double.parseDouble(manyrifmatch2.getScore3one2rid());
		} catch (Exception e) {
			score3one2rid=0.0;
		}
		double score4one2rid=0;
		try {
			score4one2rid=Double.parseDouble(manyrifmatch2.getScore4one2rid());
		} catch (Exception e) {
			score4one2rid=0;
		}
		double score5one2rid=0;
		try {
			score5one2rid=Double.parseDouble(manyrifmatch2.getScore5one2rid());
		} catch (Exception e) {
			score5one2rid=0;
		}
		double score6one2rid=0;
		try {
			score6one2rid=Double.parseDouble(manyrifmatch2.getScore6one2rid());
		} catch (Exception e) {
			score6one2rid=0;
		}
		double score7one2rid=0;
		try {
			score7one2rid=Double.parseDouble(manyrifmatch2.getScore7one2rid());
		} catch (Exception e) {
			score7one2rid=0;
		}
		double score8one2rid=0;
		try {
			score8one2rid=Double.parseDouble(manyrifmatch2.getScore8one2rid());
		} catch (Exception e) {
			score8one2rid=0;
		}
		double score9one2rid=0;
		try {
			score9one2rid=Double.parseDouble(manyrifmatch2.getScore9one2rid());
		} catch (Exception e) {
			score9one2rid=0;
		}
		double score10one2rid=0;
		try {
			score10one2rid=Double.parseDouble(manyrifmatch2.getScore10one2rid());
		} catch (Exception e) {
			score10one2rid=0;
		}
		double score11one2rid=0;
		try {
			score11one2rid=Double.parseDouble(manyrifmatch2.getScore11one2rid());
		} catch (Exception e) {
			score11one2rid=0;
		}
		double score12one2rid=0;
		try {
			score12one2rid=Double.parseDouble(manyrifmatch2.getScore12one2rid());
		} catch (Exception e) {
			score12one2rid=0;
		}
		double score13one2rid=0;
		try {
			score13one2rid=Double.parseDouble(manyrifmatch2.getScore13one2rid());
		} catch (Exception e) {
			score13one2rid=0;
		}
		double score14one2rid=0;
		try {
			score14one2rid=Double.parseDouble(manyrifmatch2.getScore14one2rid());
		} catch (Exception e) {
			score14one2rid=0;
		}
		double score15one2rid=0;
		try {
			score15one2rid=Double.parseDouble(manyrifmatch2.getScore15one2rid());
		} catch (Exception e) {
			score15one2rid=0;
		}
		double score16one2rid=0;
		try {
			score16one2rid=Double.parseDouble(manyrifmatch2.getScore16one2rid());
		} catch (Exception e) {
			score16one2rid=0;
		}
		double score1one3rid=0;
		try {
			score1one3rid=Double.parseDouble(manyrifmatch2.getScore1one3rid());
		} catch (Exception e) {
			score1one3rid=0.0;
		}
		double score2one3rid=0;
		try {
			score2one3rid=Double.parseDouble(manyrifmatch2.getScore2one3rid());
		} catch (Exception e) {
			score2one3rid=0.0;
		}
		double score3one3rid=0;
		try {
			score3one3rid=Double.parseDouble(manyrifmatch2.getScore3one3rid());
		} catch (Exception e) {
			score3one3rid=0.0;
		}
		double score4one3rid=0;
		try {
			score4one3rid=Double.parseDouble(manyrifmatch2.getScore4one3rid());
		} catch (Exception e) {
			score4one3rid=0;
		}
		double score5one3rid=0;
		try {
			score5one3rid=Double.parseDouble(manyrifmatch2.getScore5one3rid());
		} catch (Exception e) {
			score5one3rid=0;
		}
		double score6one3rid=0;
		try {
			score6one3rid=Double.parseDouble(manyrifmatch2.getScore6one3rid());
		} catch (Exception e) {
			score6one3rid=0;
		}
		double score7one3rid=0;
		try {
			score7one3rid=Double.parseDouble(manyrifmatch2.getScore7one3rid());
		} catch (Exception e) {
			score7one3rid=0;
		}
		double score8one3rid=0;
		try {
			score8one3rid=Double.parseDouble(manyrifmatch2.getScore8one3rid());
		} catch (Exception e) {
			score8one3rid=0;
		}
		double score9one3rid=0;
		try {
			score9one3rid=Double.parseDouble(manyrifmatch2.getScore9one3rid());
		} catch (Exception e) {
			score9one3rid=0;
		}
		double score10one3rid=0;
		try {
			score10one3rid=Double.parseDouble(manyrifmatch2.getScore10one3rid());
		} catch (Exception e) {
			score10one3rid=0;
		}
		double score11one3rid=0;
		try {
			score11one3rid=Double.parseDouble(manyrifmatch2.getScore11one3rid());
		} catch (Exception e) {
			score11one3rid=0;
		}
		double score12one3rid=0;
		try {
			score12one3rid=Double.parseDouble(manyrifmatch2.getScore12one3rid());
		} catch (Exception e) {
			score12one3rid=0;
		}
		double score13one3rid=0;
		try {
			score13one3rid=Double.parseDouble(manyrifmatch2.getScore13one3rid());
		} catch (Exception e) {
			score13one3rid=0;
		}
		double score14one3rid=0;
		try {
			score14one3rid=Double.parseDouble(manyrifmatch2.getScore14one3rid());
		} catch (Exception e) {
			score14one3rid=0;
		}
		double score15one3rid=0;
		try {
			score15one3rid=Double.parseDouble(manyrifmatch2.getScore15one3rid());
		} catch (Exception e) {
			score15one3rid=0;
		}
		double score16one3rid=0;
		try {
			score16one3rid=Double.parseDouble(manyrifmatch2.getScore16one3rid());
		} catch (Exception e) {
			score16one3rid=0;
		}
		double score1two1rid=0;
		try {
			score1two1rid=Double.parseDouble(manyrifmatch2.getScore1two1rid());
		} catch (Exception e) {
			score1two1rid=0.0;
		}
		double score2two1rid=0;
		try {
			score2two1rid=Double.parseDouble(manyrifmatch2.getScore2two1rid());
		} catch (Exception e) {
			score2two1rid=0.0;
		}
		double score3two1rid=0;
		try {
			score3two1rid=Double.parseDouble(manyrifmatch2.getScore3two1rid());
		} catch (Exception e) {
			score3two1rid=0.0;
		}
		double score4two1rid=0;
		try {
			score4two1rid=Double.parseDouble(manyrifmatch2.getScore4two1rid());
		} catch (Exception e) {
			score4two1rid=0;
		}
		double score5two1rid=0;
		try {
			score5two1rid=Double.parseDouble(manyrifmatch2.getScore5two1rid());
		} catch (Exception e) {
			score5two1rid=0;
		}
		double score6two1rid=0;
		try {
			score6two1rid=Double.parseDouble(manyrifmatch2.getScore6two1rid());
		} catch (Exception e) {
			score6two1rid=0;
		}
		double score7two1rid=0;
		try {
			score7two1rid=Double.parseDouble(manyrifmatch2.getScore7two1rid());
		} catch (Exception e) {
			score7two1rid=0;
		}
		double score8two1rid=0;
		try {
			score8two1rid=Double.parseDouble(manyrifmatch2.getScore8two1rid());
		} catch (Exception e) {
			score8two1rid=0;
		}
		double score9two1rid=0;
		try {
			score9two1rid=Double.parseDouble(manyrifmatch2.getScore9two1rid());
		} catch (Exception e) {
			score9two1rid=0;
		}
		double score10two1rid=0;
		try {
			score10two1rid=Double.parseDouble(manyrifmatch2.getScore10two1rid());
		} catch (Exception e) {
			score10two1rid=0;
		}
		double score11two1rid=0;
		try {
			score11two1rid=Double.parseDouble(manyrifmatch2.getScore11two1rid());
		} catch (Exception e) {
			score11two1rid=0;
		}
		double score12two1rid=0;
		try {
			score12two1rid=Double.parseDouble(manyrifmatch2.getScore12two1rid());
		} catch (Exception e) {
			score12two1rid=0;
		}
		double score13two1rid=0;
		try {
			score13two1rid=Double.parseDouble(manyrifmatch2.getScore13two1rid());
		} catch (Exception e) {
			score13two1rid=0;
		}
		double score14two1rid=0;
		try {
			score14two1rid=Double.parseDouble(manyrifmatch2.getScore14two1rid());
		} catch (Exception e) {
			score14two1rid=0;
		}
		double score15two1rid=0;
		try {
			score15two1rid=Double.parseDouble(manyrifmatch2.getScore15two1rid());
		} catch (Exception e) {
			score15two1rid=0;
		}
		double score16two1rid=0;
		try {
			score16two1rid=Double.parseDouble(manyrifmatch2.getScore16two1rid());
		} catch (Exception e) {
			score16two1rid=0;
		}
		double score1two2rid=0;
		try {
			score1two2rid=Double.parseDouble(manyrifmatch2.getScore1two2rid());
		} catch (Exception e) {
			score1two2rid=0.0;
		}
		double score2two2rid=0;
		try {
			score2two2rid=Double.parseDouble(manyrifmatch2.getScore2two2rid());
		} catch (Exception e) {
			score2two2rid=0.0;
		}
		double score3two2rid=0;
		try {
			score3two2rid=Double.parseDouble(manyrifmatch2.getScore3two2rid());
		} catch (Exception e) {
			score3two2rid=0.0;
		}
		double score4two2rid=0;
		try {
			score4two2rid=Double.parseDouble(manyrifmatch2.getScore4two2rid());
		} catch (Exception e) {
			score4two2rid=0;
		}
		double score5two2rid=0;
		try {
			score5two2rid=Double.parseDouble(manyrifmatch2.getScore5two2rid());
		} catch (Exception e) {
			score5two2rid=0;
		}
		double score6two2rid=0;
		try {
			score6two2rid=Double.parseDouble(manyrifmatch2.getScore6two2rid());
		} catch (Exception e) {
			score6two2rid=0;
		}
		double score7two2rid=0;
		try {
			score7two2rid=Double.parseDouble(manyrifmatch2.getScore7two2rid());
		} catch (Exception e) {
			score7two2rid=0;
		}
		double score8two2rid=0;
		try {
			score8two2rid=Double.parseDouble(manyrifmatch2.getScore8two2rid());
		} catch (Exception e) {
			score8two2rid=0;
		}
		double score9two2rid=0;
		try {
			score9two2rid=Double.parseDouble(manyrifmatch2.getScore9two2rid());
		} catch (Exception e) {
			score9two2rid=0;
		}
		double score10two2rid=0;
		try {
			score10two2rid=Double.parseDouble(manyrifmatch2.getScore10two2rid());
		} catch (Exception e) {
			score10two2rid=0;
		}
		double score11two2rid=0;
		try {
			score11two2rid=Double.parseDouble(manyrifmatch2.getScore11two2rid());
		} catch (Exception e) {
			score11two2rid=0;
		}
		double score12two2rid=0;
		try {
			score12two2rid=Double.parseDouble(manyrifmatch2.getScore12two2rid());
		} catch (Exception e) {
			score12two2rid=0;
		}
		double score13two2rid=0;
		try {
			score13two2rid=Double.parseDouble(manyrifmatch2.getScore13two2rid());
		} catch (Exception e) {
			score13two2rid=0;
		}
		double score14two2rid=0;
		try {
			score14two2rid=Double.parseDouble(manyrifmatch2.getScore14two2rid());
		} catch (Exception e) {
			score14two2rid=0;
		}
		double score15two2rid=0;
		try {
			score15two2rid=Double.parseDouble(manyrifmatch2.getScore15two2rid());
		} catch (Exception e) {
			score15two2rid=0;
		}
		double score16two2rid=0;
		try {
			score16two2rid=Double.parseDouble(manyrifmatch2.getScore16two2rid());
		} catch (Exception e) {
			score16two2rid=0;
		}
		double score1two3rid=0;
		try {
			score1two3rid=Double.parseDouble(manyrifmatch2.getScore1two3rid());
		} catch (Exception e) {
			score1two3rid=0.0;
		}
		double score2two3rid=0;
		try {
			score2two3rid=Double.parseDouble(manyrifmatch2.getScore2two3rid());
		} catch (Exception e) {
			score2two3rid=0.0;
		}
		double score3two3rid=0;
		try {
			score3two3rid=Double.parseDouble(manyrifmatch2.getScore3two3rid());
		} catch (Exception e) {
			score3two3rid=0.0;
		}
		double score4two3rid=0;
		try {
			score4two3rid=Double.parseDouble(manyrifmatch2.getScore4two3rid());
		} catch (Exception e) {
			score4two3rid=0;
		}
		double score5two3rid=0;
		try {
			score5two3rid=Double.parseDouble(manyrifmatch2.getScore5two3rid());
		} catch (Exception e) {
			score5two3rid=0;
		}
		double score6two3rid=0;
		try {
			score6two3rid=Double.parseDouble(manyrifmatch2.getScore6two3rid());
		} catch (Exception e) {
			score6two3rid=0;
		}
		double score7two3rid=0;
		try {
			score7two3rid=Double.parseDouble(manyrifmatch2.getScore7two3rid());
		} catch (Exception e) {
			score7two3rid=0;
		}
		double score8two3rid=0;
		try {
			score8two3rid=Double.parseDouble(manyrifmatch2.getScore8two3rid());
		} catch (Exception e) {
			score8two3rid=0;
		}
		double score9two3rid=0;
		try {
			score9two3rid=Double.parseDouble(manyrifmatch2.getScore9two3rid());
		} catch (Exception e) {
			score9two3rid=0;
		}
		double score10two3rid=0;
		try {
			score10two3rid=Double.parseDouble(manyrifmatch2.getScore10two3rid());
		} catch (Exception e) {
			score10two3rid=0;
		}
		double score11two3rid=0;
		try {
			score11two3rid=Double.parseDouble(manyrifmatch2.getScore11two3rid());
		} catch (Exception e) {
			score11two3rid=0;
		}
		double score12two3rid=0;
		try {
			score12two3rid=Double.parseDouble(manyrifmatch2.getScore12two3rid());
		} catch (Exception e) {
			score12two3rid=0;
		}
		double score13two3rid=0;
		try {
			score13two3rid=Double.parseDouble(manyrifmatch2.getScore13two3rid());
		} catch (Exception e) {
			score13two3rid=0;
		}
		double score14two3rid=0;
		try {
			score14two3rid=Double.parseDouble(manyrifmatch2.getScore14two3rid());
		} catch (Exception e) {
			score14two3rid=0;
		}
		double score15two3rid=0;
		try {
			score15two3rid=Double.parseDouble(manyrifmatch2.getScore15two3rid());
		} catch (Exception e) {
			score15two3rid=0;
		}
		double score16two3rid=0;
		try {
			score16two3rid=Double.parseDouble(manyrifmatch2.getScore16two3rid());
		} catch (Exception e) {
			score16two3rid=0;
		}
		
		
		
		
		
	}
		
		return null;
	}
}
