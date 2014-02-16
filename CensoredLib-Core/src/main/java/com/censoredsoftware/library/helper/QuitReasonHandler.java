package com.censoredsoftware.library.helper;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * @deprecated FIXME This class is out of date.
 */
@Deprecated
public class QuitReasonHandler extends Handler
{
	public static QuitReason latestQuit = QuitReason.QUITTING;

	@Override
	public void publish(LogRecord record)
	{
		if(!record.getMessage().toLowerCase().contains("disconnect")) return;
		latestQuit = QuitReason.QUITTING;
		if(record.getMessage().toLowerCase().contains("genericreason")) latestQuit = QuitReason.GENERIC_REASON;
		else if(record.getMessage().toLowerCase().contains("spam")) latestQuit = QuitReason.SPAM;
		else if(record.getMessage().toLowerCase().contains("endofstream")) latestQuit = QuitReason.END_OF_STREAM;
		else if(record.getMessage().toLowerCase().contains("overflow")) latestQuit = QuitReason.OVERFLOW;
		else if(record.getMessage().toLowerCase().contains("timeout")) latestQuit = QuitReason.TIMEOUT;
	}

	@Override
	public void flush()
	{}

	@Override
	public void close() throws SecurityException
	{}

	public enum QuitReason
	{
		GENERIC_REASON, SPAM, END_OF_STREAM, OVERFLOW, TIMEOUT, QUITTING
	}
}