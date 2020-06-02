package com.apt.modernization.datamodel.dataServices;

import com.apt.modernization.datamodel.calculation.DistributionValues;
import com.apt.modernization.datamodel.calculation.EquiDistributionVector;
import com.apt.modernization.datamodel.calculation.ExpectedLoss;
import com.apt.modernization.datamodel.calculation.Panjer;
import com.apt.modernization.datamodel.document.CoverageComponent;
import com.apt.modernization.datamodel.document.Quote;
import com.apt.modernization.datamodel.repository.QuotesRepository;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;

@Component
@EnableMongoRepositories(basePackageClasses = QuotesRepository.class)
public class DataProcess {
    private QuotesRepository quotesRepository;
    private List<Quote> quoteList;
    Logger logger = Logger.getLogger(DataProcess.class.getName());

    public DataProcess(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
        processRepository();
    }

    public void processRepository(){
        Long count = Long.valueOf(0);
        quoteList = quotesRepository.findAll();
        logger.info("Data has been loaded");
        EquiDistributionVector equiDistributionVector;
        for(Quote quote : quoteList){
            count++;
            if(count % 1000 == 0)logger.info(count  + " quotes have been processed");
            //logger.info(quote.getQuoteId()  + " is being processed");
            for(CoverageComponent coverageComponent : quote.getCoverageComponents()){
                Double expLoss = 0.;
                //logger.info(coverageComponent.getId() + "is being processed");
                List<DistributionValues> xpcValues;
                equiDistributionVector = new EquiDistributionVector(coverageComponent.getCoverageComponentConfiguration().getRetention(),
                        coverageComponent.getCoverageComponentConfiguration().getLimitAmount(),
                        Math.log(coverageComponent.getCoverageComponentConfiguration().getLimitAmount())/2);
                //logger.info("panjer starts");
                Panjer panjer = new Panjer();
                xpcValues = panjer.generateCompoundDistribution(equiDistributionVector.createLogNormalVector());
                ExpectedLoss expectedLoss = new ExpectedLoss(xpcValues);
                if(!coverageComponent.getCoverageComponentConfiguration().getLimitAggregation()) {
                    expLoss = expectedLoss.expectedValueLimit(coverageComponent.getCoverageComponentConfiguration().getLimitAmount());
                }else{
                    expLoss = expectedLoss.expectedValue();
                }
                //logger.info("Expected Loss: " + expLoss);
                coverageComponent.getPremiumCoverageComponent().setExpectedLoss(expLoss);
            }
            quotesRepository.save(quote);
        }

    }
}
