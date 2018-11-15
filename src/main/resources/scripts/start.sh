#!/bin/sh

port=6666

echo "********************************************************************************************"
mkdir -p logs

outfile="logs/process.log"
if [ -f $outfile ];
then
    rm $outfile
fi

echo "Starting springLearning instance at port [$port]..."
java -jar springLearning-*.jar --server.port=$port --logging.path=logs/process >> $outfile 2>&1 &

for((i=0;i<30;i++))
{
    echo -ne "."
    sleep 1
}

cat $outfile

ps -fu $USER | grep -w "springLearning" | grep -v grep |awk '{print "Running Service - PID ["$2"] - Start Time ["$5"] - ["$11"] - ["$12"]"}'

serviceCount=($(ps -fu $USER | grep -w "springLearning" | grep -v grep | wc -l))
echo "Total service count [$serviceCount]"

#if check_if_process_is_running
#then
#    echo  -e  "\nProcess started successfully"
#    ps -fu $USER | grep -w "cm-emergency" | grep -v grep |awk '{print "Process Info - PID ["$2"] - Start Time ["$5"] - ["$11"]"}'
#    echo "********************************************************************************************"
#    exit 0
#else
#    echo  -e "\nERROR: Process could not be started, please see the logs for details"
#    echo "********************************************************************************************"
#    exit 1
#fi

echo "********************************************************************************************"


