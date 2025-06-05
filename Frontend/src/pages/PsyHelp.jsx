import React from 'react';
import './PsyHelp.css';

export default function PsyHelp() {
    return (
        <div className="psy-bg min-h-screen py-10 px-6 text-white flex flex-col justify-between">
            <div>
                <h1 className="text-2xl font-bold mb-4 text-center">Apoio Emocional 🧠💙</h1>
                <p className="text-base mb-8 text-center">
                    Você não está sozinho. Estamos aqui para ouvir você.
                </p>

                <div className="space-y-6">
                    <div className="psy-card">
                        <h2 className="text-lg font-semibold mb-1">Ligue 188 📞</h2>
                        <p className="text-sm opacity-90">
                            Atendimento gratuito 24h com voluntários preparados do CVV (Centro de Valorização da Vida).
                        </p>
                    </div>

                    <div className="psy-card">
                        <h2 className="text-lg font-semibold mb-1">Respire fundo 🌬️</h2>
                        <p className="text-sm opacity-90">
                            Inspire por 4 segundos, segure por 4 e expire por 4. Repita 4x.
                        </p>
                    </div>

                    <div className="psy-card">
                        <h2 className="text-lg font-semibold mb-1">Fale com alguém 🤝</h2>
                        <p className="text-sm opacity-90">
                            Conversar com amigos, familiares ou profissionais pode ajudar a aliviar a carga emocional.
                        </p>
                    </div>

                    <div className="psy-card">
                        <h2 className="text-lg font-semibold mb-1">Exercite-se 🏃</h2>
                        <p className="text-sm opacity-90">
                            Movimentar o corpo libera endorfinas que ajudam a melhorar o humor.
                        </p>
                    </div>
                </div>
            </div>

            <footer className="mt-12 text-center text-sm text-white text-opacity-70">
                <p>Em caso de risco à vida, procure ajuda médica imediata.</p>
            </footer>
        </div>
    );
}
