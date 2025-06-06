import React, { useState } from 'react';


export default function PsyHelpChat() {
    const [messages, setMessages] = useState([
        { from: 'bot', text: 'Oi, como você está se sentindo?', time: '14:32' },
        { from: 'user', text: 'Estou nervosa, não sei o que fazer', time: '14:33' },
        { from: 'bot', text: 'Tudo bem sentir-se assim. Vamos respirar juntos?', time: '14:34' },
    ]);

    return (
        <div className="bg-gray-900 text-white min-h-screen pb-24">
            {/* Header */}
            <header className="bg-gray-800 shadow-lg border-b border-gray-700">
                <div className="flex items-center px-4 py-4">
                    <button className="text-gray-300 hover:text-white mr-4">
                        <i className="fas fa-arrow-left text-xl" />
                    </button>
                    <div className="flex items-center flex-1">
                        <div className="w-10 h-10 bg-gradient-to-br from-pink-500 to-purple-600 rounded-full flex items-center justify-center mr-3">
                            <i className="fas fa-heart text-white text-sm" />
                        </div>
                        <div>
                            <h1 className="text-lg font-semibold">PsyHelp Assistant</h1>
                            <p className="text-sm text-green-400 flex items-center">
                                <span className="w-2 h-2 bg-green-400 rounded-full mr-2"></span>
                                Online
                            </p>
                        </div>
                    </div>
                    <button className="text-gray-300 hover:text-white">
                        <i className="fas fa-ellipsis-v text-xl" />
                    </button>
                </div>
            </header>

            {/* Chat */}
            <main className="flex-1 px-4 py-6 space-y-4 pb-24 overflow-y-auto">
                {messages.map((msg, idx) => (
                    <div key={idx} className={`flex items-start space-x-3 ${msg.from === 'bot' ? 'slide-in-left' : 'justify-end slide-in-right'}`}>
                        {msg.from === 'bot' && (
                            <div className="w-8 h-8 bg-gradient-to-br from-pink-500 to-purple-600 rounded-full flex items-center justify-center flex-shrink-0">
                                <i className="fas fa-heart text-white text-xs" />
                            </div>
                        )}

                        <div className="max-w-xs">
                            <div className={`px-4 py-3 shadow-lg rounded-2xl ${msg.from === 'bot' ? 'bg-gray-700 rounded-tl-md' : 'bg-gradient-to-r from-orange-500 to-red-500 rounded-tr-md'}`}>
                                <p className="text-sm leading-relaxed">{msg.text}</p>
                            </div>
                            <p className={`text-gray-500 text-xs mt-1 ${msg.from === 'user' ? 'text-right mr-2' : 'ml-2'}`}>{msg.time}</p>
                        </div>

                        {msg.from === 'user' && (
                            <div className="w-8 h-8 bg-gradient-to-br from-orange-500 to-red-500 rounded-full flex items-center justify-center flex-shrink-0">
                                <i className="fas fa-user text-white text-xs" />
                            </div>
                        )}
                    </div>
                ))}
            </main>

            {/* Typing Indicator */}
            <div className="fixed bottom-4 left-0 right-0 flex justify-center">
                <div className="flex space-x-1 items-center">
                    <div className="w-2 h-2 bg-white rounded-full typing-indicator typing-dot"></div>
                    <div className="w-2 h-2 bg-white rounded-full typing-indicator typing-dot"></div>
                    <div className="w-2 h-2 bg-white rounded-full typing-indicator typing-dot"></div>
                </div>
            </div>
        </div>
    );
}
